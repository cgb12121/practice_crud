//package com.backend.practice.util.dump.controller.advice.exception;
//
//import com.backend.practice.util.exception.TooManyAttemptsException;
//import com.backend.practice.util.exception.UserAlreadyExistException;
//import com.backend.practice.util.exception.UserNotFoundException;
//import com.backend.practice.util.exception.WrongPasswordException;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ExceptionHandlerAdvice {
//
//    @ExceptionHandler(UserAlreadyExistException.class)
//    @Operation(summary = "Handle UserAlreadyExistException")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "409", description = "User already exists")
//    })
//    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(UserNotFoundException.class)
//    @Operation(summary = "Handle UserNotFoundException")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "404", description = "User not found")
//    })
//    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(WrongPasswordException.class)
//    @Operation(summary = "Handle WrongPasswordException")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "401", description = "Wrong password")
//    })
//    public ResponseEntity<String> handleWrongPasswordException(WrongPasswordException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler(TooManyAttemptsException.class)
//    @Operation(summary = "Handle WrongPasswordException")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "401", description = "Logged in fail many times")
//    })
//    public ResponseEntity<String> handleWTooManyAttemptsException(TooManyAttemptsException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler({Exception.class, RuntimeException.class})
//    @Operation(summary = "Handle all other exceptions")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    public ResponseEntity<String> handleGlobalException(Exception ex) {
//        return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
