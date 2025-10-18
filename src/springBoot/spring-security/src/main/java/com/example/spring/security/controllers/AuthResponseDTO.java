package com.example.spring.security.controllers;

import java.util.Date;

public class AuthResponseDTO {
    private String type;
    private String token;
    private long expiresIn;

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String token, Date expiresIn, String type) {
        this.token = token;
        this.expiresIn = expiresIn.getTime();
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresInMs) {
        this.expiresIn = expiresInMs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
