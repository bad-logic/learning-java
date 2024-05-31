package com.example.lab.post;

import com.example.lab.post.dto.CreatePostDTO;
import com.example.lab.post.dto.PatchPostDTO;
import com.example.lab.post.dto.PostDTO;

import java.util.UUID;

public class PostMapper {

    public static Post toEntity(CreatePostDTO p) {
        if (p == null) return null;
        Post post = new Post();
        post.setTitle(p.getTitle());
        post.setContent(p.getContent());
        post.setAuthorId(p.getAuthor_id());
        return post;
    }

    public static Post toEntity(UUID id, PatchPostDTO p) {
        if (p == null) return null;
        return new Post(id, p.getTitle(), p.getContent());
    }

    public static PostDTO toPostDTO(Post p) {
        if (p == null) return null;
        return new PostDTO(p.getId(), p.getTitle(), p.getContent(), p.getAuthorId());
    }
}
