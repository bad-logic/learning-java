package com.example.lab.comment;

import java.util.Optional;
import java.util.UUID;

public interface CommentService {

    Comment add(UUID postId, Comment comment);

    Comment findByIdAndPostIdAndUserId(UUID id, UUID postId, UUID userId);

}
