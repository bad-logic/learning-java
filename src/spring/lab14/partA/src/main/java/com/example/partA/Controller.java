package com.example.partA;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/shop")
    public ResponseEntity<?> shop(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/orders")
    public ResponseEntity<?> orders(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/payments")
    public ResponseEntity<?> payment(){
        return ResponseEntity.ok("OK");
    }
}
