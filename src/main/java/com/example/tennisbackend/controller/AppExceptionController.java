package com.example.tennisbackend.controller;

import com.example.tennisbackend.dto.ErrorResponseDto;
import com.example.tennisbackend.exceptions.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionController {
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<Object> handleApiException(ApiException ex, WebRequest request) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(ex.getStatus().value(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }
}
