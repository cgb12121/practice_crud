package com.backend.practice.api.controller.advice.exception;

import com.backend.practice.util.exception.TooManyAttemptsException;
import com.backend.practice.util.exception.UserAlreadyExistException;
import com.backend.practice.util.exception.UserNotFoundException;
import com.backend.practice.util.exception.WrongPasswordException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    @Operation(summary = "Handle UserAlreadyExistException")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @Operation(summary = "Handle UserNotFoundException")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongPasswordException.class)
    @Operation(summary = "Handle WrongPasswordException")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "Wrong password")
    })
    public ResponseEntity<Object> handleWrongPasswordException(WrongPasswordException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TooManyAttemptsException.class)
    @Operation(summary = "Handle WrongPasswordException")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "Logged in fail many times")
    })
    public ResponseEntity<Object> handleWTooManyAttemptsException(TooManyAttemptsException ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

}
