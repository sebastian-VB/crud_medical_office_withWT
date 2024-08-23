package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.PersonService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByDniValidation implements ConstraintValidator<ExistsByDni, String>{

    @Autowired
    private PersonService personService;

    @Override
    public boolean isValid(String dni, ConstraintValidatorContext context) {
        if(personService == null){
            return true;
        }
        return !personService.existsByDni(dni);
    }

}
