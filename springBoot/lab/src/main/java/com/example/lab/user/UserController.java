package com.example.lab.user;


import com.example.lab.aop.annotation.ExecutionTime;
import com.example.lab.comment.CommentMapper;
import com.example.lab.comment.CommentServiceImpl;
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
    private final CommentServiceImpl commentService;

    @Autowired
    UserController(UserServiceImpl service, CommentServiceImpl commentService) {
        this.userService = service;
        this.commentService = commentService;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getAll().stream().map(UserMapper::toUserDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/with-post-title")
    public ResponseEntity<Map<String, Object>> getUsersWithPostTitle(@RequestParam(defaultValue = "") String title) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getUsersWithPostTitle(title).stream().map(UserMapper::toUserDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> addUser(@Valid @RequestBody CreateUserDTO data) throws Exception {
        throw new Exception("unknown exception occured");
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "POST successful");
//        response.put("data", UserMapper.toUserDTO(this.userService.add(UserMapper.toEntity(data))));
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/with-more-than-n-post")
    public ResponseEntity<Map<String, Object>> getUsersWithMoreThanOnePost(@RequestParam(defaultValue = "1") int n) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getUserWithPostsCountGreaterThan(n).stream().map(UserMapper::toUserDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<Map<String, Object>> getSingleUserById(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", UserMapper.toUserDTO(this.userService.getById(id)));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Map<String, Object>> getUsersPost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.userService.getPosts(id).stream().map(PostMapper::toPostDTO).collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Map<String, Object>> getUsersPostComment(@PathVariable @NonNull UUID userId, @PathVariable @NonNull UUID postId, @PathVariable @NonNull UUID commentId) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", CommentMapper.toCommentDTO(this.commentService.findByIdAndPostIdAndUserId(commentId, postId, userId)));
        return ResponseEntity.ok(response);
    }


}
