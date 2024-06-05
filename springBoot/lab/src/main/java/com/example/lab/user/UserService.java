package com.example.lab.user;


import com.example.lab.common.CustomService;
import com.example.lab.post.Post;

import java.util.List;
import java.util.UUID;

public interface UserService extends CustomService<User, UUID> {

    List<Post> getPosts(UUID id);

    List<User> getUserWithPostsCountGreaterThan(int count);

    List<User> getUsersWithPostTitle(String title);

    User getUserByEmail(String email);
}
