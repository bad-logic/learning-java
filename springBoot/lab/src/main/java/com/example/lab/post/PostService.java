package com.example.lab.post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);

    List<Post> getPosts();

    public List<Post> getPostsByAttributes(String author, String title);

    Post add(Post p);

    Post patchPost(Post patch);

    void deletePost(UUID id);

}
