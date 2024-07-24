package com.backend.practice.api.controller;

import com.backend.practice.authentication.JwtAuthenticationResponse;
import com.backend.practice.model.dto.request.UserLoginRequest;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth-test", description = "Auth Testing")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody UserLoginRequest request) throws AccessDeniedException {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserRegisterRequest request) throws AccessDeniedException {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }
}
