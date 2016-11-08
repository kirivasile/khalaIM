package com.github.kirivasile.khala_im.chat;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.model.Chat;

public class ChatActivity extends AppCompatActivity {
    public static final String DATA_TAG = "Data";

    private Chat mChat;
    private RecyclerView mRecyclerView;
    private ChatRVAdapter mAdapter;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        try {
            Intent intent = getIntent();
            if (intent != null) {
                Bundle args = intent.getExtras();
                mChat = (Chat) args.getSerializable(DATA_TAG);

                manageToolBar();

                mRecyclerView = (RecyclerView) findViewById(R.id.chatRecyclerView);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                mRecyclerView.setLayoutManager(layoutManager);

                mAdapter = new ChatRVAdapter(mChat.getMessages(), this, "Артанис");
                mRecyclerView.setAdapter(mAdapter);
            } else {
                Log.e("CHAT", "Data not received");
            }
        } catch (Exception e) {
            Log.e("CHAT", "Failed to set up chat activity: " + e.toString());
        }
    }

    private void manageToolBar() {
        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mToolBar.setTitle(mChat.getName());
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener((View view) -> {
            onBackPressed();
        });
    }
}
