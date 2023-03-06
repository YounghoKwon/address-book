package com.example.addressbook.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.example.addressbook.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorResponse(final NotFoundException exception,
        final HttpServletRequest request) {
        return ResponseEntity.badRequest()
            .body(ErrorResponse.create(exception, BAD_REQUEST, exception.getMessage()));
    }

}
