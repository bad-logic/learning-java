package com.example.lab.auth.dto;

import com.example.lab.common.Roles;
import com.example.lab.common.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterDTO {
    @NotBlank(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "password is mandatory")
    @ValidPassword
    private String password;

    private Roles role;

    @NotBlank(message = "password is mandatory")
    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
