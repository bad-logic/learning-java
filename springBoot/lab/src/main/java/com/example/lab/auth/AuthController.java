package com.example.lab.auth;

import com.example.lab.auth.dto.UserLoginDTO;
import com.example.lab.auth.dto.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO data) {
        return ResponseEntity.ok("ok");


//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "POST successful");
//            response.put("data", UserMapper.toUserDTO(this.userService.add(UserMapper.toEntity(data))));
//            return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO data) {
        return ResponseEntity.ok("ok");
    }
}
