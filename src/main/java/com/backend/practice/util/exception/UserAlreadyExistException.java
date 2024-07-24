package com.backend.practice.util.exception;

public class UserAlreadyExistException extends  RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
