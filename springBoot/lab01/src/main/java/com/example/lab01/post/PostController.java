package com.example.lab01.post;

import com.example.lab01.common.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.postService.getPosts());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getPostsMadeByAuthor(@DefaultValue("") @RequestParam String author) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.postService.getPostsByAuthor(author));
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> savePost(@Valid @RequestBody CreatePostDTO p) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "post added successfully!!!");
        response.put("data", this.postService.add(Mapper.toEntity(p)));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSinglePost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", this.postService.getPost(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        this.postService.deletePost(id);
        response.put("message", "post deleted successfully!!!");
        response.put("data", id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPost(@PathVariable @NonNull UUID id, @RequestBody JsonPatch patch) {

        try {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "post updated successfully!!!");
            response.put("data", this.postService.patchPost(id, patch));
            return ResponseEntity.ok(response);
        } catch (UnrecognizedPropertyException e) {
            System.out.println(e.toString());
            ErrorResponse<String> error = new ErrorResponse<String>("Patch Failed", "Unrecognized field \"" + e.getPropertyName() + "\"" + "known properties " + e.getKnownPropertyIds());
            return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (JsonPatchException | JsonProcessingException e) {
            System.out.println(e.toString());
            ErrorResponse<String> error = new ErrorResponse<String>("Patch Failed", "Invalid operation or path");
            return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

}
