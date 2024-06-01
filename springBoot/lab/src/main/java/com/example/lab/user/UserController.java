package com.example.lab.user;


import com.example.lab.post.PostMapper;
import com.example.lab.user.dto.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    UserController(UserServiceImpl service) {
        this.userService = service;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getUsers().stream().map(UserMapper::toUserDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> addUser(@Valid @RequestBody CreateUserDTO data) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "POST successful");
        response.put("data", UserMapper.toUserDTO(this.userService.add(UserMapper.toEntity(data))));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/with-more-than-one-post")
    public ResponseEntity<Map<String, Object>> getUsersWithMoreThanOnePost() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getUserWithPostsCountGreaterThan(1).stream().map(UserMapper::toUserDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSingleUser(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", UserMapper.toUserDTO(this.userService.getUser(id)));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Map<String, Object>> getUsersPost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getPosts(id).stream().map(PostMapper::toPostDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

}
