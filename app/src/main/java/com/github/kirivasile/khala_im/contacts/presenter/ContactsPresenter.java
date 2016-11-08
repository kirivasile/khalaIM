package com.github.kirivasile.khala_im.contacts.presenter;

import com.github.kirivasile.khala_im.chats.view.ChatsFragment;
import com.github.kirivasile.khala_im.contacts.view.ContactsFragment;
import com.github.kirivasile.khala_im.model.Chat;
import com.github.kirivasile.khala_im.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class ContactsPresenter {
    private ContactsFragment mView;

    public ContactsPresenter(ContactsFragment mView) {
        this.mView = mView;
    }

    public void loadContacts() {
        List<User> result = new ArrayList<>();
        String imageUrl = "https://pp.vk.me/c837323/v837323805/a369/8wwF5g76W40.jpg";
        String bigText = "Статус типичного террана";
        User user = new User(imageUrl, "Некий терран", bigText);
        result.add(user);
        result.add(user);
        result.add(user);
        mView.setContacts(result);
    }
}
