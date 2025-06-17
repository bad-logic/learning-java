package pdfgenerator.explorer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Welcome.
 */
@Controller
public class Welcome {
    /**
     * Get welcome message response entity.
     *
     * @return the response entity
     */
    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage(){
        return new ResponseEntity<>("Welcome from springboot!!!", HttpStatus.OK);
    }
}
