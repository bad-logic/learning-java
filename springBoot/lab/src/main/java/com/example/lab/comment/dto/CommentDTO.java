package com.example.lab.comment.dto;

import java.util.UUID;

public class CommentDTO {
    private UUID id;
    private String comment;
    private UUID postId;

    public CommentDTO(UUID id, String comment, UUID postId) {
        this.id = id;
        this.comment = comment;
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPostId() {
        return postId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", postId=" + postId +
                '}';
    }
}
