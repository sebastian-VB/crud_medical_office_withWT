package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean existsByDni(String dni) {
        return personRepository.existsByDni(dni);
    }

}
