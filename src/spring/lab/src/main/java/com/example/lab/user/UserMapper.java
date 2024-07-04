package com.example.lab.user;


import com.example.lab.auth.dto.UserRegisterDTO;
import com.example.lab.user.dto.UserDTO;

public class UserMapper {
    public static User toEntity(UserRegisterDTO u) {
        if (u == null) return null;
        return new User(u.getName(), u.getEmail(), u.getPassword(), u.getRole());
    }

    public static UserDTO toUserDTO(User u) {
        if (u == null) return null;
        return new UserDTO(u.getId(), u.getName(), u.getEmail());
    }
}
