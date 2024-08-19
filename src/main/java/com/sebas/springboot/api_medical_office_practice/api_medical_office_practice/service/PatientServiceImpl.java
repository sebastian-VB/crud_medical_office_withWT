package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Patient;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Person;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.PatientRepository;


@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        
        Person person = new Person(
            patient.getPerson().getName(), 
            patient.getPerson().getLastname(), 
            patient.getPerson().getDni(), 
            patient.getPerson().getPhone()
        );

        Patient newPatient = new Patient(patient.getOrder_attention());
        newPatient.setPerson(person);
        return patientRepository.save(newPatient);
    }

    @Override
    public Optional<Patient> update(Long id, Patient patient) {
        
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if(optionalPatient.isPresent()){

            Patient patientDB = optionalPatient.orElseThrow();

            patientDB.getPerson().setName(patient.getPerson().getName());
            patientDB.getPerson().setLastname(patient.getPerson().getLastname());
            patientDB.getPerson().setDni(patient.getPerson().getDni());;
            patientDB.getPerson().setPhone(patient.getPerson().getPhone());

            patientDB.setOrder_attention(patient.getOrder_attention());
            patientRepository.save(patientDB);
        }

        return optionalPatient;
    }

}
