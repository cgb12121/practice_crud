//package com.backend.practice.util.dump.controller;
//
//import com.backend.practice.model.dto.UserDto;
//import com.backend.practice.model.dto.request.ChangePasswordRequest;
//import com.backend.practice.model.dto.request.UserDeleteAccountRequest;
//import com.backend.practice.model.dto.request.UserLoginRequest;
//import com.backend.practice.model.dto.request.UserRegisterRequest;
//import com.backend.practice.service.UserService;
//import com.backend.practice.util.exception.TooManyAttemptsException;
//import com.backend.practice.util.exception.UserAlreadyExistException;
//import com.backend.practice.util.exception.UserNotFoundException;
//import com.backend.practice.util.exception.WrongPasswordException;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    @Operation(summary = "Register a new user")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User registered successfully",
//                    content = @Content(schema = @Schema(implementation = UserDto.class))),
//            @ApiResponse(responseCode = "409", description = "User already exists")
//    })
//    public ResponseEntity<UserDto> signUp(
//            @Parameter(description = "User registration request data", required = true)
//            @Validated @RequestBody UserRegisterRequest request)
//            throws UserAlreadyExistException {
//        UserDto userDto = userService.signUp(request);
//        return ResponseEntity.ok(userDto);
//    }
//
//    @PostMapping("/login")
//    @Operation(summary = "Login user")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User logged in successfully",
//                    content = @Content(schema = @Schema(implementation = UserDto.class))),
//            @ApiResponse(responseCode = "401", description = "Wrong password"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    public ResponseEntity<UserDto> loginUser(
//            @Parameter(description = "User login request data", required = true)
//            @RequestBody UserLoginRequest request)
//            throws TooManyAttemptsException, UserNotFoundException, WrongPasswordException {
//        UserDto userDto = userService.loginUser(request);
//        return ResponseEntity.ok(userDto);
//    }
//
//    @DeleteMapping("/delete")
//    @Operation(summary = "Delete user account")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "User account deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    public ResponseEntity<Void> deleteUser(
//            @Parameter(description = "User delete account request data", required = true)
//            @RequestBody UserDeleteAccountRequest request)
//            throws UserNotFoundException {
//        userService.deleteUser(request);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/change_password")
//    @Operation(summary = "Change user password")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Password changed successfully"),
//            @ApiResponse(responseCode = "401", description = "Wrong password"),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    public ResponseEntity<String> changePassword(
//            @Parameter(description = "Change password request data", required = true)
//            @RequestBody ChangePasswordRequest request)
//            throws UserNotFoundException, WrongPasswordException {
//        String message = userService.changePassword(request);
//        return ResponseEntity.ok(message);
//    }
//
//    @PutMapping("/update_info/{id}")
//    @Operation(summary = "Update user information")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "User information updated successfully",
//                content = @Content(schema = @Schema(implementation = UserDto.class))),
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    public ResponseEntity<UserDto> updateUserInfo(
//            @Parameter(description = "User ID", example = "1", required = true)
//            @PathVariable Integer id,
//            @Parameter(description = "Updated user information", required = true)
//            @RequestBody UserDto request)
//            throws UserNotFoundException {
//        UserDto updatedUser = userService.updateUserInfo(id, request);
//        return ResponseEntity.ok(updatedUser);
//    }
//}
