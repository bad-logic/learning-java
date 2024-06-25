package com.example.lab.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePostDTO {
    @NotBlank(message = "title is mandatory")
    @Size(min = 2, max = 50, message = "title must be between 2 and 50 characters")
    private String title;

    @NotBlank(message = "content is mandatory")
    @Size(min = 2, max = 250, message = "content must be between 2 and 250 characters")
    private String content;


    public CreatePostDTO() {
    }

    public CreatePostDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "CreatePostDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


