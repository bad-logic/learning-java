package com.example.docker_setup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Welcome {
    /**
     * Get welcome message response entity.
     *
     * @return the response entity
     */
    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage(){
        return new ResponseEntity<>("Welcome From SpringBoot Server!!!", HttpStatus.OK);
    }
}
