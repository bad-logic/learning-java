package com.example.spring.security.objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class Principal {

    private final String username;
    private final SimpleGrantedAuthority role;

    public Principal(String username,String role){
        this.username = username;
        this.role = new SimpleGrantedAuthority("ROLE_"+role);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    public String getUsername() {
        return this.username;
    }
}
