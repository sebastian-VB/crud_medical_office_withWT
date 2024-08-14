package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;

public interface DoctorService {

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    Doctor save(Doctor doctor);

    //TODO: POR EL MOMENTO ESOS 3 METODOS
}
