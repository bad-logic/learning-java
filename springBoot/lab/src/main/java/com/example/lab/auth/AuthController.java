package com.example.lab.auth;

import com.example.lab.auth.dto.UserLoginDTO;
import com.example.lab.auth.dto.UserRegisterDTO;
import com.example.lab.auth.util.JWTUtil;
import com.example.lab.common.ErrorResponse;
import com.example.lab.user.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController()
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    private final BCryptPasswordEncoder passwordEncoder;

    private JWTUtil jwtUtil;

    @Autowired
    public AuthController(AuthService authService, BCryptPasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO data) {
        Map<String, Object> response = new HashMap<>();
        if (this.authService.loadUserByUsername(data.getEmail()) != null) {
            response.put("email", "User with this email already exists");
            ErrorResponse<Map<String, Object>> error = new ErrorResponse<Map<String, Object>>(HttpStatus.NOT_FOUND.name(), response);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        response.put("message", "POST successful");
        data.setPassword(this.passwordEncoder.encode(data.getPassword()));
        response.put("data", UserMapper.toUserDTO(this.authService.register(UserMapper.toEntity(data))));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO data) {
        Map<String, Object> response = new HashMap<>();
        AuthDetails existingUser = this.authService.loadUserByUsername(data.getEmail());
        if (existingUser == null) {
            response.put("message", "Incorrect Credentials");
            ErrorResponse<Map<String, Object>> error = new ErrorResponse<Map<String, Object>>(HttpStatus.BAD_REQUEST.name(), response);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        if (!this.passwordEncoder.matches(data.getPassword(), existingUser.getPassword())) {
            response.put("message", "Incorrect Credentials");
            ErrorResponse<Map<String, Object>> error = new ErrorResponse<Map<String, Object>>(HttpStatus.BAD_REQUEST.name(), response);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("access_token", "Bearer " + this.jwtUtil.generateToken(existingUser));
        responseData.put("refresh_token", this.jwtUtil.generateRefreshToken(existingUser.getEmail()));
        response.put("message", "login successful");
        response.put("data", responseData);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
