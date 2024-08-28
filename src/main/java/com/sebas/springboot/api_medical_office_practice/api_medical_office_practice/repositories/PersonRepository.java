package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

    boolean existsByDni(String dni);
    Optional<Person> findByDni(String dni);
}
