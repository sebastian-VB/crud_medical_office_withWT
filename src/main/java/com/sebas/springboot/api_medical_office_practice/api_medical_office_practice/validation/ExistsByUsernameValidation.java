package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String>{

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext contet) {
        if(userService == null){
            return true;
        }

        return !userService.existsByUsername(username);
    }

}
