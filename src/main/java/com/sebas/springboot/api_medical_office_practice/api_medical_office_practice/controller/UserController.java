package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.User;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.UserService;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.shared.MethodsForValidation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){

        if(result.hasErrors()){
            return MethodsForValidation.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
