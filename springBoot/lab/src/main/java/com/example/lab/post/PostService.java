package com.example.lab.post;

import com.example.lab.common.CustomService;

import java.util.List;
import java.util.UUID;

public interface PostService extends CustomService<Post, UUID> {
//    Post getPost(UUID id);
//
//    List<Post> getPosts();

    public List<Post> getPostsByAttributes(String author, String title);

//    Post add(Post p);
//
//    Post patchPost(Post patch);
//
//    void deletePost(UUID id);

}
