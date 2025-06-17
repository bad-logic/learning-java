package pdfgenerator.explorer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Welcome {
    @GetMapping("/")
    public ResponseEntity<String> getWelcomeMessage(){
        return new ResponseEntity<>("Welcome from springboot", HttpStatus.OK);
    }
}
