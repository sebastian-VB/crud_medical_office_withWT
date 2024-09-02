package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.models.CustomError;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<CustomError> noResourceFound(Exception e){
        CustomError error = new CustomError();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CustomError> methodArgumentTypeMismatch(Exception e){
        CustomError error = new CustomError();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
