package com.example.spring.security.controllers;

import com.example.spring.security.objects.Principal;
import com.example.spring.security.services.AccountService;
import com.example.spring.security.services.JWTService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/auth")
public class Auth {
    private static final Logger LOGGER = LoggerFactory.getLogger(Auth.class);
    private final AccountService accountService;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public Auth(AccountService accountService, AuthenticationManager authenticationManager, JWTService jwtService){
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO authObject){
        LOGGER.info("logging in...");
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authObject.getUsername(),
                            authObject.getPassword()
                    )
            );
            Principal user = accountService.loadAccountDetailsByUserNameAndPassword(authObject.getUsername());
            String token = this.jwtService.generateToken(user);
            return new ResponseEntity<>(new AuthResponseDTO(token, this.jwtService.extractClaim(token,Claims::getExpiration),"Bearer"), HttpStatus.OK);
        }catch (Exception ex){
            LOGGER.error(ex.toString());
            return new ResponseEntity<>(new ErrorResponseDTO("incorrect credentials"), HttpStatus.UNAUTHORIZED);
        }
    }
}
