package com.example.lab.user;

import com.example.lab.common.CustomServiceImpl;
import com.example.lab.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl extends CustomServiceImpl<User, UUID> implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

//    @Override
//    public User getById(UUID id) {
//        Optional<User> u = this.userRepository.findById(id);
//        return u.orElse(null);
//    }

//    @Override
//    public List<User> getAll() {
//        return this.userRepository.findAll();
//    }

//    @Override
//    public User add(User p) {
//        this.userRepository.save(p);
//        return p;
//    }

    @Override
    public List<Post> getPosts(UUID id) {
        Optional<User> u = this.userRepository.findById(id);
        return u.map(User::getPosts).orElse(null);
    }

    @Override
    public List<User> getUserWithPostsCountGreaterThan(int count) {
        return this.userRepository.getUsersWithPostsGreaterThan(count);
    }

    @Override
    public List<User> getUsersWithPostTitle(String title) {
        return this.userRepository.getUsersWithPostsTitle(title);
    }
}
