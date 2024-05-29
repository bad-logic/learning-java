package com.example.lab01.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePostDTO {
    @NotBlank(message = "title is mandatory")
    @Size(min = 2, max = 50, message = "title must be between 2 and 50 characters")
    private String title;

    @NotBlank(message = "content is mandatory")
    @Size(min = 2, max = 250, message = "content must be between 2 and 250 characters")
    private String content;

    @NotBlank(message = "author is mandatory")
    @Size(min = 2, max = 50, message = "author name must be between 2 and 50 characters")
    private String author;

    public CreatePostDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
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

    public String toString() {
        return "title: " + title + ", content: " + content + ", author: " + author;
    }
}


