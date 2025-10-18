package com.example.spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Welcome {

    private static final Logger LOGGER = LoggerFactory.getLogger(Welcome.class);

    /**
     * Get welcome message response entity.
     *
     * @return the response entity
     */
    @RequestMapping(path = "/",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<String> getWelcomeMessage(){
        LOGGER.info("get welcome message");

        Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("authtoken {}",authToken);
        return new ResponseEntity<>("Welcome from Spring BootServer!!!", HttpStatus.OK);
    }

}
