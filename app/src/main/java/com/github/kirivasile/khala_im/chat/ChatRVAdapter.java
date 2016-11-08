package com.github.kirivasile.khala_im.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.model.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class ChatRVAdapter extends RecyclerView.Adapter<ChatRVAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class LeftViewHolder extends ViewHolder {
        TextView messageAuthor;
        TextView messageText;
        ImageView authorAvatar;

        public LeftViewHolder(View itemView) {
            super(itemView);
            authorAvatar = (ImageView) itemView.findViewById(R.id.leftChatMessageAvatar);
            messageAuthor = (TextView) itemView.findViewById(R.id.leftChatMessageAuthor);
            messageText = (TextView) itemView.findViewById(R.id.leftChatMessage);
        }
    }

    public static class RightViewHolder extends ViewHolder {
        TextView messageText;

        public RightViewHolder(View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.rightChatMessage);
        }
    }

    private static final int LEFT_MESSAGE = 0;
    private static final int RIGHT_MESSAGE = 1;

    private List<Message> mMessages;
    private String mUserName;
    private Context mContext;

    public ChatRVAdapter(List<Message> mMessages, Context context, String userName) {
        this.mMessages = mMessages;
        this.mContext = context;
        this.mUserName = userName;
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = mMessages.get(position);
        if (holder.getItemViewType() == LEFT_MESSAGE) {
            LeftViewHolder leftHolder = (LeftViewHolder) holder;
            leftHolder.messageAuthor.setText(message.getAuthor().getNick());
            leftHolder.messageText.setText(message.getText());
            Picasso.with(mContext)
                    .load(message.getAuthor().getAvatarUrl())
                    .into(leftHolder.authorAvatar);
        } else if (holder.getItemViewType() == RIGHT_MESSAGE) {
            RightViewHolder rightHolder = (RightViewHolder) holder;
            rightHolder.messageText.setText(message.getText());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LEFT_MESSAGE) {
            Context context = parent.getContext();
            View v = LayoutInflater.from(context).inflate(R.layout.left_chat_message,
                    parent, false);
            return new LeftViewHolder(v);
        } else {
            Context context = parent.getContext();
            View v = LayoutInflater.from(context).inflate(R.layout.right_chat_message,
                    parent, false);
            return new RightViewHolder(v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getAuthor().getNick().equals(mUserName)
                ? RIGHT_MESSAGE : LEFT_MESSAGE;
    }
}
