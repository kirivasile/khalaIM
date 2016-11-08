package com.github.kirivasile.khala_im.contacts.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.chat.ChatActivity;
import com.github.kirivasile.khala_im.chats.presenter.ChatsPresenter;
import com.github.kirivasile.khala_im.model.Chat;
import com.github.kirivasile.khala_im.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class ContactsRVAdapter extends RecyclerView.Adapter<ContactsRVAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private ImageView mUserAvatar;
        private TextView mUserName;
        private TextView mText;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.cardView);
            mUserAvatar = (ImageView) itemView.findViewById(R.id.chatsUserAvatar);
            mUserName = (TextView) itemView.findViewById(R.id.chatsUserName);
            mText = (TextView) itemView.findViewById(R.id.chatsTextHeader);
        }
    }

    private List<User> mContacts;
    private Context mContext;

    public ContactsRVAdapter(Context context) {
        mContacts = new ArrayList<>();
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
        User user = mContacts.get(position);
        holder.mUserName.setText(user.getNick());
        holder.mText.setText(user.getStatus());
        Picasso.with(mContext)
                .load(user.getAvatarUrl())
                .into(holder.mUserAvatar);
        holder.mCardView.setOnClickListener((View view) -> {
            Intent intent = new Intent(mContext, ChatActivity.class);
            Bundle args = new Bundle();
            args.putSerializable(ChatActivity.DATA_TAG, ChatsPresenter.getTempChat());
            intent.putExtras(args);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public void setContacts(List<User> users) {
        mContacts = users;
        notifyDataSetChanged();
    }
}
