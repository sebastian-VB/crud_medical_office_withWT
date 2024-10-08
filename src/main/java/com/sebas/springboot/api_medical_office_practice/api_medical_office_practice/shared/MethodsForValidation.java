package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.shared;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class MethodsForValidation {

    public static ResponseEntity<?> validation(BindingResult result){
        
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put("message", err.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    public static ResponseEntity<?> validationInService(String message){

        Map<String, String> error = new HashMap<>();
        error.put("message", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
