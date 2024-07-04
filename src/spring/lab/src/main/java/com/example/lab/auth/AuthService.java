package com.example.lab.auth;

import com.example.lab.user.User;
import com.example.lab.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AuthDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getUserByEmail(username);
        if (user != null) {
            return new AuthDetails(user);
        }
        return null;
    }

    public User register(User u) {
        return this.userService.add(u);
    }
}
