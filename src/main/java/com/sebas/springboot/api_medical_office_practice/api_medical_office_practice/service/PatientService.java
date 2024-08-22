package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Patient;

public interface PatientService {

    List<Patient> findAll();

    Optional<Patient> findById(Long id);

    Patient save(Patient patient);

    Optional<Patient> update(Long id, Patient patient);
}
