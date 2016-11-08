package com.github.kirivasile.khala_im.chats.presenter;

import com.github.kirivasile.khala_im.chats.view.ChatsFragment;
import com.github.kirivasile.khala_im.model.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class ChatsPresenter {
    private ChatsFragment mView;

    public ChatsPresenter(ChatsFragment mView) {
        this.mView = mView;
    }

    public void loadChats() {
        List<Chat> result = new ArrayList<>();
        String imageUrl = "https://pp.vk.me/c837323/v837323805/a369/8wwF5g76W40.jpg";
        String bigText = "До вторжения зергов Айур был цветущим миром - чистые океаны, буйные " +
                "джунгли, сверкающие города. Умеренный уровень парниковых газов и малый " +
                "эксцентриситет орбиты делали климат планеты пригодным для жизни. Влажные леса " +
                "Айура населяли бесчисленные виды живых существ. Самыми развитыми обитателями " +
                "планеты были протоссы.";
        Chat chat = new Chat(imageUrl, "Некий терран", bigText);
        result.add(chat);
        result.add(chat);
        result.add(chat);
        result.add(chat);
        mView.setChats(result);
    }
}
