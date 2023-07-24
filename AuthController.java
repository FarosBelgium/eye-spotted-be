package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.DTO.LoginDetailDTO;
import com.faros.EyeSpotted.model.DTO.RegisterDetailDTO;
import com.faros.EyeSpotted.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDetailDTO loginDetail) {
        return authService.login(loginDetail);
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterDetailDTO registerDetail) {
        authService.register(registerDetail);
    }
}
