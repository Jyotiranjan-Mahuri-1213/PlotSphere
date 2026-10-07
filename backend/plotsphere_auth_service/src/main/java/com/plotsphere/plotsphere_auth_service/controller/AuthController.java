package com.plotsphere.plotsphere_auth_service.controller;

import com.plotsphere.plotsphere_auth_service.dto.LoginRequest;
import com.plotsphere.plotsphere_auth_service.dto.LoginResponse;
import com.plotsphere.plotsphere_auth_service.dto.UserResponse;
import com.plotsphere.plotsphere_auth_service.entity.User;
import com.plotsphere.plotsphere_auth_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody User user) {

        User registeredUser = authService.register(user);

        UserResponse response = new UserResponse(
                registeredUser.getId(),
                registeredUser.getName(),
                registeredUser.getEmail(),
                registeredUser.getMobileNo(),
                registeredUser.getRole()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(response);
    }
}