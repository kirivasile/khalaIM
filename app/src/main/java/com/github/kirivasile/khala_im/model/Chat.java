package com.github.kirivasile.khala_im.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kirill on 08.11.2016.
 */
public class Chat implements Serializable {
    private String avatarUrl;
    private String name;
    private String text;
    private List<Message> messages;

    public Chat(String avatarUrl, String name, String text, List<Message> messages) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.text = text;
        this.messages = messages;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
