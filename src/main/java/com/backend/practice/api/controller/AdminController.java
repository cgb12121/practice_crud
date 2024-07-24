package com.backend.practice.api.controller;

import com.backend.practice.model.dto.UserDto;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.service.AdminService;
import com.backend.practice.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final AuthenticationService authenticationService;

    @PostMapping("/create")
    @Operation(summary = "Create account for staff")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public ResponseEntity<UserDto> registerUser(
            @Parameter(description = "User registration request data", required = true)
            @Validated @RequestBody UserRegisterRequest request) {
        UserDto userDto = adminService.createStaff(request);
        authenticationService.signUp(request);
        return ResponseEntity.ok(userDto);
    }
}
