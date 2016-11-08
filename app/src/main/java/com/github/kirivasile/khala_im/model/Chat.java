package com.github.kirivasile.khala_im.model;

/**
 * Created by Kirill on 08.11.2016.
 */
public class Chat {
    private String avatarUrl;
    private String name;
    private String text;

    public Chat(String avatarUrl, String name, String text) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.text = text;
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
}
