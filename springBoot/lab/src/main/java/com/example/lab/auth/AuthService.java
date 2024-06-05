package com.example.lab.auth;

import com.example.lab.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements UserDetailsService {

    private final UserServiceImpl userService;

    @Autowired
    public AuthService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AuthDetails(this.userService.getUserByEmail(username));
    }
}
