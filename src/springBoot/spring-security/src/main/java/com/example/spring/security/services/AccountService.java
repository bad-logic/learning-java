package com.example.spring.security.services;

import com.example.spring.security.objects.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    public Principal loadAccountDetailsByUserNameAndPassword(String username){
        LOGGER.info("loadAccountDetailsByUserName");
        return new Principal("user","USER");
    }
}
