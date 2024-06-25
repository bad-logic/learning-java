package com.example.lab.comment;


import com.example.lab.post.Post;
import com.example.lab.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;

    }

    @Override
    public Comment add(UUID postId, Comment comment) {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isPresent()) {
            Post p = post.get();
            p.addComment(comment);
            Post addedPost = this.postRepository.save(p);
            return addedPost.getComments().get(addedPost.getComments().size() - 1);
        }
        return null;
    }

    @Override
    public Comment findByIdAndPostIdAndUserId(UUID id, UUID postId, UUID userId) {
        Optional<Comment> comment = this.commentRepository.findByIdAndPostIdAndUserId(id, postId, userId);
        return comment.orElse(null);
    }
}
