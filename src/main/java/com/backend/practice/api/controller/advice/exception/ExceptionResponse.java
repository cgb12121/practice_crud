package com.backend.practice.api.controller.advice.exception;

public record ExceptionResponse(java.time.LocalDate timestamp, String message, String details) {
}
