package com.github.kirivasile.khala_im.chats.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.model.Chat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class ChatsRVAdapter extends RecyclerView.Adapter<ChatsRVAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mUserAvatar;
        private TextView mUserName;
        private TextView mText;

        public ViewHolder(View itemView) {
            super(itemView);
            mUserAvatar = (ImageView) itemView.findViewById(R.id.chatsUserAvatar);
            mUserName = (TextView) itemView.findViewById(R.id.chatsUserName);
            mText = (TextView) itemView.findViewById(R.id.chatsTextHeader);
        }
    }

    private List<Chat> mChats;
    private Context mContext;

    public ChatsRVAdapter(Context context) {
        mChats = new ArrayList<>();
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.card_in_chats,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chat chat = mChats.get(position);
        holder.mUserName.setText(chat.getName());
        holder.mText.setText(chat.getText());
        Picasso.with(mContext)
                .load(chat.getAvatarUrl())
                .into(holder.mUserAvatar);
    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public void setChats(List<Chat> chats) {
        mChats = chats;
        notifyDataSetChanged();
    }
}
