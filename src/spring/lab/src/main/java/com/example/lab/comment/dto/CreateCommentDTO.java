package com.example.lab.comment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCommentDTO {

    @NotBlank(message = "comment is mandatory")
    @Size(min = 2, max = 250, message = "comment must be between 2 and 250 characters")
    private String comment;

    public CreateCommentDTO() {
    }

    public CreateCommentDTO(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CreateCommentDTO{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
