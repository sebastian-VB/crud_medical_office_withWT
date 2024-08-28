package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Person;

public interface PersonService {

    boolean existsByDni(String dni);
    Optional<Person> findByDni(String dni);
}
