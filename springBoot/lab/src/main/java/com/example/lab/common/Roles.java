package com.example.lab.common;

import java.util.stream.Stream;

public enum Roles {
    USER("USER"), ADMIN("ADMIN");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public String getRole() {
        return value;
    }

    public static Roles of(String role) {
        return Stream.of(Roles.values())
                .filter(p -> p.getRole().equals(role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
