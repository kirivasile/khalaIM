package com.github.kirivasile.khala_im.model;

/**
 * Created by Kirill on 08.11.2016.
 */
public class User {
    private String avatarUrl;
    private String nick;
    private String status;

    public User(String avatarUrl, String nick, String status) {
        this.avatarUrl = avatarUrl;
        this.nick = nick;
        this.status = status;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getNick() {
        return nick;
    }

    public String getStatus() {
        return status;
    }
}
