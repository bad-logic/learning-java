package com.example.lab.post;

import com.example.lab.common.ErrorResponse;
import com.example.lab.post.dto.CreatePostDTO;
import com.example.lab.post.dto.PatchPostDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    PostController(PostServiceImpl postService) {
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
        response.put("message", "POST successful");
        response.put("data", PostMapper.toPostDTO(this.postService.add(PostMapper.toEntity(p))));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSinglePost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", PostMapper.toPostDTO((this.postService.getPost(id))));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePost(@PathVariable @NonNull UUID id) {
        Map<String, Object> response = new HashMap<>();
        this.postService.deletePost(id);
        response.put("message", "DELETE successful");
        response.put("data", id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPost(@PathVariable @NonNull UUID id, @RequestBody JsonPatch patch) throws NoResourceFoundException {

        try {
            Post p = this.postService.getPost(id);
            System.out.println("post from database: " + p);

            if (p != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JsonNode patched = patch.apply(objectMapper.convertValue(p, JsonNode.class));

                // filter out unmodifiable data, allow only modifiable data to be changed
                // this is defined inside patchPayload
                PatchPostDTO patchPayload = objectMapper.treeToValue(patched, PatchPostDTO.class);

                Map<String, Object> response = new HashMap<>();
                // inconsistent data return see the issue
                response.put("data", PostMapper.toPostDTO(this.postService.patchPost(PostMapper.toEntity(id, patchPayload))));
                response.put("message", "PATCH successful");
                return ResponseEntity.ok(response);
            }

            throw new NoResourceFoundException(HttpMethod.PATCH, "post not found");

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
