package com.example.lab01.post;

import java.io.Serializable;
import java.util.UUID;

public class Post implements Serializable {
    private UUID id;
    private String title;
    private String content;
    private String author;

    public Post(UUID id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
