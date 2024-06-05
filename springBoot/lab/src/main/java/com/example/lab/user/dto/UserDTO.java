package com.example.lab.user.dto;

import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String name;
    private String email;

    public UserDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
