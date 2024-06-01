package com.example.lab.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    
    @Query("select p FROM Post p JOIN User u ON u.id = p.authorId WHERE u.name LIKE %:author% and p.title LIKE %:title% ")
    public List<Post> findPostsByAttributes(String author, String title);
}
