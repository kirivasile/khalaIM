package com.github.kirivasile.khala_im.contacts.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.chats.presenter.ChatsPresenter;
import com.github.kirivasile.khala_im.chats.view.ChatsRVAdapter;
import com.github.kirivasile.khala_im.contacts.presenter.ContactsPresenter;
import com.github.kirivasile.khala_im.model.User;

import java.util.List;


public class ContactsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ContactsRVAdapter mAdapter;
    private ContactsPresenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        try {
            manageToolBar();

            mRecyclerView = (RecyclerView) view.findViewById(R.id.contactsRecyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManager);

            mAdapter = new ContactsRVAdapter(getActivity());
            mRecyclerView.setAdapter(mAdapter);

            mPresenter = new ContactsPresenter(this);
            mPresenter.loadContacts();
        } catch (Exception e) {
            Log.e("CHATS", "Failed to set up chats fragment: " + e.toString());
        }
        return view;
    }

    private void manageToolBar() {
        ActionBar toolBar =  ((AppCompatActivity)getActivity()).getSupportActionBar();
        toolBar.setTitle(R.string.Contacts);
    }

    public void setContacts(List<User> contacts) {
        mAdapter.setContacts(contacts);
    }
}
