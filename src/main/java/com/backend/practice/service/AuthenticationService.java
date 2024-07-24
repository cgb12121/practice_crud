package com.backend.practice.service;

import com.backend.practice.authentication.JwtAuthenticationResponse;
import com.backend.practice.model.dto.request.UserLoginRequest;
import com.backend.practice.model.dto.request.UserRegisterRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse login(UserLoginRequest request);

    JwtAuthenticationResponse signUp (UserRegisterRequest request);
}
