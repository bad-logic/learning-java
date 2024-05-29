package com.example.lab01.post;

import com.example.lab01.common.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return this.postRepository.get();
    }

    public List<Post> getPostsByAuthor(String author) {
        return this.postRepository.get(author);
    }

    public Post add(Post p) {
        this.postRepository.save(p);
        return p;
    }

    public Optional<Post> getPost(UUID id) {
        return this.postRepository.get(id);
    }

    public void deletePost(UUID id) {
        this.postRepository.delete(id);
    }

    public Post patchPost(UUID id, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        Optional<Post> p = this.getPost(id);
        if (p.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode patched = patch.apply(objectMapper.convertValue(p.get(), JsonNode.class));
            PatchDTO patchPayload = objectMapper.treeToValue(patched, PatchDTO.class);
            return this.postRepository.update(id, Mapper.toEntity(id, patchPayload));
        }
        return null;
    }

}
