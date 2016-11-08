package com.github.kirivasile.khala_im.model;

import java.io.Serializable;

/**
 * Created by Kirill on 08.11.2016.
 */
public class Message implements Serializable {
    private User author;
    private String text;

    public Message(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
