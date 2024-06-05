package com.example.lab.user;

import com.example.lab.common.Roles;
import com.example.lab.post.Post;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "author_id", nullable = false)
    private List<Post> posts;

    @Column(nullable = false)
    private String role;

    @Transient
    private Roles roleHolder;

    @PrePersist
    void fillPersistent() {
        if (role != null) {
            this.role = roleHolder.getRole();
        }
    }

    @PostLoad
    void fillTransient() {
        if (role != null) {
            this.roleHolder = Roles.of(role);
        }
    }

    public User() {
    }

    public User(String name, String email, String password, Roles role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleHolder = role;
    }

    public User(UUID id, String name, String email, String password, Roles role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleHolder = role;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return roleHolder;
    }

    public void setRole(Roles role) {
        this.roleHolder = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

}
