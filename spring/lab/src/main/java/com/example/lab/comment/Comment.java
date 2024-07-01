package com.example.lab.comment;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String comment;

    @Column(name = "post_id", insertable = false, updatable = false, nullable = false)
    private UUID postId;

    public Comment() {
    }

    public Comment(UUID id, String comment, UUID postId) {
        this.id = id;
        this.comment = comment;
        this.postId = postId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", postId=" + postId +
                '}';
    }
}
