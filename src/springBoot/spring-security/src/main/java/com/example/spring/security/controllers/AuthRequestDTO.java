package com.example.spring.security.controllers;

public class AuthRequestDTO {
    private String username;
    private String password;
    
    public AuthRequestDTO() {
    }

    public AuthRequestDTO(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
