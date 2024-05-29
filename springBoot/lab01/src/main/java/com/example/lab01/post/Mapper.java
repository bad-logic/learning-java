package com.example.lab01.post;

import java.util.UUID;

public class Mapper {

    public static Post toEntity(CreatePostDTO p) {
        if (p == null) return null;
        return new Post(UUID.randomUUID(), p.getTitle(), p.getContent(), p.getAuthor());
    }

    public static Post toEntity(UUID id, PatchDTO p) {
        if (p == null) return null;
        return new Post(id, p.getTitle(), p.getContent(), p.getAuthor());
    }
}
