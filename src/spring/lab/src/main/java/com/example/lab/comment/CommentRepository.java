package com.example.lab.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    @Query("SELECT c FROM Comment c JOIN Post p ON c.id = :commentId WHERE p.id = :postId AND p.authorId = :userId")
    Optional<Comment> findByIdAndPostIdAndUserId(UUID commentId, UUID postId, UUID userId);
}
