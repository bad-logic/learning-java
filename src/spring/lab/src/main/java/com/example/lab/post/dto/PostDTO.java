package com.example.lab.post.dto;

import java.util.UUID;

public class PostDTO {
    private UUID id;
    private String title;
    private String content;
    private UUID author_id;

    public PostDTO(UUID id, String title, String content, UUID author_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public UUID getAuthor_id() {
        return author_id;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
