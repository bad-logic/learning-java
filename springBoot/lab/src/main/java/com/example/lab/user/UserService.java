package com.example.lab.user;


import com.example.lab.post.Post;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUser(UUID id);

    List<User> getUsers();

    User add(User p);

    List<Post> getPosts(UUID id);

    List<User> getUserWithPostsCountGreaterThan(int count);
}
