package com.example.lab01.post;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class PostDTO extends CreatePostDTO {
    @NotBlank(message = "id is mandatory")
    private UUID id;

    public PostDTO(UUID id, String title, String content, String author) {
        super(title, content, author);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String toString() {
        return "id: " + id + ", title: " + this.getTitle() + ", content: " + this.getContent() + ", author: " + this.getAuthor();
    }

}
