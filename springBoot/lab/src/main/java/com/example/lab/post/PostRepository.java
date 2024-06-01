package com.example.lab.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query("select u.posts from User u where u.name LIKE %:author%")
//    @Query("select p FROM Post p JOIN User u ON u.id = p.author_id WHERE u.name = :authorName")
    public List<Post> findPostsByAuthor(String author);
}
