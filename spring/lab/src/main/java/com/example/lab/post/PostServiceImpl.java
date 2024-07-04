package com.example.lab.post;

import com.example.lab.common.CustomServiceImpl;
import com.example.lab.user.User;
import com.example.lab.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl extends CustomServiceImpl<Post, UUID> implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        super(postRepository);
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

//    @Override
//    public List<Post> getAll() {
//        return this.postRepository.findAll();
//    }

    public List<Post> getPostsByAttributes(String author, String title) {
        return this.postRepository.findPostsByAttributes(author, title);
    }

    @Override
    public Post add(Post p) {
        Optional<User> user = this.userRepository.findById(p.getAuthorId());
        if (user.isPresent()) {
            var u = user.get();
            u.addPost(p);
            var us = this.userRepository.save(u);
            return us.getPosts().get(us.getPosts().size() - 1);
        }

        return null;
    }

//    public Post getPost(UUID id) {
//        Optional<Post> post = this.postRepository.findById(id);
//        return post.orElse(null);
//    }

//    public void deletePost(UUID id) {
//        this.postRepository.deleteById(id);
//    }

//    public Post patchPost(Post patch) {
//        return this.postRepository.save(patch);
//    }

}
