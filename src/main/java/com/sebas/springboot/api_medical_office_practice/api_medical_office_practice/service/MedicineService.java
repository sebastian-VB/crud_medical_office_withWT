package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;

public interface MedicineService {

    List<Medicine> findAll();

    Optional<Medicine> findById(Long id);

    Medicine save(Medicine medicine);

    Optional<Medicine> update(Medicine medicine, Long id);

}
