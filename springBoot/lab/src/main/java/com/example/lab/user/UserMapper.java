package com.example.lab.user;


import com.example.lab.user.dto.CreateUserDTO;
import com.example.lab.user.dto.UserDTO;

public class UserMapper {
    public static User toEntity(CreateUserDTO u) {
        if (u == null) return null;
        User user = new User();
        user.setName(u.getName());
        return user;
    }

    public static UserDTO toUserDTO(User u) {
        if (u == null) return null;
        return new UserDTO(u.getId(), u.getName());
    }
}
