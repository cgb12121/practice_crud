package com.backend.practice.util.exception;

public class TooManyAttemptsException extends Exception{
    public TooManyAttemptsException(String message) {
        super(message);
    }
}
