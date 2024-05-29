package com.example.lab01.post;

import com.example.lab01.common.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class PostRepository implements Repository<UUID, Post> {
    private final ArrayList<Post> postData = new ArrayList<>() {{
        add(new Post(UUID.randomUUID(), "post1", "hello this is my first post", "Author 1"));
        add(new Post(UUID.randomUUID(), "post2", "hello this is my second post", "Author 1"));
        add(new Post(UUID.randomUUID(), "How to Learn Java", "hello this is my first post", "Author 2"));
    }};

    public ArrayList<Post> getAllPosts() {
        return postData;
    }

//    public void addPost(Post postData) {
//        this.postData.add(postData);
//    }

//    public Optional<Post> getPost(UUID id) {
//        return this.postData.stream().filter((x) -> x.getId().equals(id)).findFirst();
//    }

//    public Post updatePost(UUID id, Post p) {
//        Optional<Post> prevSnapshot = this.getPost(id);
//        if (prevSnapshot.isPresent()) {
//            int index = this.postData.indexOf(prevSnapshot.get());
//            this.postData.remove(prevSnapshot.get());
//            this.postData.add(index, p);
//            return p;
//        }
//        return null;
//    }

//    public void deletePost(UUID id) {
//        Optional<Post> p = this.getPost(id);
//        if (p.isPresent()) {
//            this.postData.remove(p.get());
//        }
//    }

    @Override
    public void save(Post data) {
        this.postData.add(data);
    }

    @Override
    public Optional<Post> get(UUID id) {
        return this.postData.stream().filter((x) -> x.getId().equals(id)).findFirst();
    }

    @Override
    public List<Post> get() {
        return this.postData;
    }

    public List<Post> get(String author) {
        return this.postData.stream().filter(x -> x.getAuthor().contains(author)).collect(Collectors.toList());
    }

    @Override
    public Post update(UUID id, Post data) {
        Optional<Post> prevSnapshot = this.get(id);
        if (prevSnapshot.isPresent()) {
            int index = this.postData.indexOf(prevSnapshot.get());
            this.postData.remove(prevSnapshot.get());
            this.postData.add(index, data);
            return data;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Optional<Post> p = this.get(id);
        if (p.isPresent()) {
            this.postData.remove(p.get());
        }
    }
}
