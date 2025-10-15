package com.example.spring.security.objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private final String password;
    private final String username;
    private final SimpleGrantedAuthority role;

    public User(String username,String password,String role){
        this.password = password;
        this.username = username;
        this.role = new SimpleGrantedAuthority("ROLE_"+role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
