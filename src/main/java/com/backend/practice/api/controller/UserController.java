package com.backend.practice.api.controller;

import com.backend.practice.config.LogoutHandler;
import com.backend.practice.service.AuthenticationService;
import com.backend.practice.util.exception.TooManyAttemptsException;
import com.backend.practice.model.dto.UserDto;
import com.backend.practice.model.dto.request.ChangePasswordRequest;
import com.backend.practice.model.dto.request.UserDeleteAccountRequest;
import com.backend.practice.model.dto.request.UserLoginRequest;
import com.backend.practice.model.dto.request.UserRegisterRequest;
import com.backend.practice.service.UserService;
import com.backend.practice.util.exception.UserNotFoundException;
import com.backend.practice.util.exception.WrongPasswordException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Tutorial", description = "Tutorial management APIs")
public class UserController {

    private final UserService userService;

    private final AuthenticationService authenticationService;

    private final LogoutHandler logoutHandler;

    @PostMapping("/signup")
    @Operation(summary = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public ResponseEntity<UserDto> registerUser(
            @Parameter(description = "User registration request data", required = true)
            @Validated @RequestBody UserRegisterRequest request) {
        UserDto userDto = userService.signUp(request);
        authenticationService.signUp(request);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in successfully"),
            @ApiResponse(responseCode = "401", description = "Wrong password"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserDto> loginUser(
            @Parameter(description = "User login request data", required = true)
            @RequestBody UserLoginRequest request) throws TooManyAttemptsException, WrongPasswordException, UserNotFoundException, AccessDeniedException {
        UserDto userDto = userService.loginUser(request);
        authenticationService.login(request);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete user account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> deleteUser(
            @Parameter(description = "User delete account request data", required = true)
            @RequestBody UserDeleteAccountRequest request) {
        userService.deleteUser(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/change_password")
    @Operation(summary = "Change user password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password changed successfully"),
            @ApiResponse(responseCode = "401", description = "Wrong password"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> changePassword(
            @Parameter(description = "Change password request data", required = true)
            @RequestBody ChangePasswordRequest request) {
        String message = userService.changePassword(request);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/update_info/{id}")
    @Operation(summary = "Update user information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User information updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<?> updateUserInfo(
            @Parameter(description = "User ID", example = "1", required = true)
            @PathVariable Integer id,
            @Parameter(description = "Updated user information", required = true)
            @RequestBody UserDto request) {
        UserDto updatedUser = userService.updateUserInfo(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/logout")
    @Operation(summary = "Log out")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Something wrong occurred")
    })
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        logoutHandler.logout(request, response, authentication);
        return "Logged out successfully";
    }

}
