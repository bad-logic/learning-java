package com.example.spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Welcome {

    private static final Logger LOGGER = LoggerFactory.getLogger(Welcome.class);

    /**
     * Get welcome message response entity.
     *
     * @return the response entity
     */
    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage(){
        LOGGER.info("get welcome message");
        return new ResponseEntity<>("Welcome from Spring BootServer!!!", HttpStatus.OK);
    }

}
