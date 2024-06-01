package com.example.lab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select u from User u where SIZE(u.posts) > :count")
    public List<User> getUsersWithPostsGreaterThan(int count);

    @Query("select u from User u join Post p on u.id=p.authorId where p.title like %:title%")
    public List<User> getUsersWithPostsTitle(String title);
}
