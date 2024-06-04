package com.example.lab.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserDTO {
    @NotBlank(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    private String name;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
