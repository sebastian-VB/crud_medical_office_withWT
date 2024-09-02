package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Person;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.DoctorRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.PersonRepository;

import jakarta.validation.ValidationException;


@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Transactional
    @Override
    public Doctor save(Doctor doctor) {

        if(personRepository.existsByDni(doctor.getPerson().getDni())){
            throw new ValidationException("Dni ya existe");
        }

        Person newPerson = new Person(
            doctor.getPerson().getName(), 
            doctor.getPerson().getLastname(),
            doctor.getPerson().getDni(), 
            doctor.getPerson().getPhone()
        );
        
        Doctor newDoctor = new Doctor(doctor.getSpeciality());
        newDoctor.setPerson(newPerson);

        return doctorRepository.save(doctor);
    }

    @Transactional
    @Override
    public Optional<Doctor> update(Long id, Doctor doctor) {
        
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);

        if(optionalDoctor.isPresent()){
            Doctor updateDoctor = optionalDoctor.orElseThrow();
            
            if(personRepository.existsByDni(doctor.getPerson().getDni()) && !updateDoctor.getId().equals(id)){
                throw new ValidationException("Dni ya existe");
            }

            Person updatePerson = new Person();
            updatePerson.setName(doctor.getPerson().getName());
            updatePerson.setLastname(doctor.getPerson().getLastname());
            updatePerson.setDni(doctor.getPerson().getDni());
            updatePerson.setPhone(doctor.getPerson().getPhone());

            updateDoctor.setPerson(updatePerson);
            updateDoctor.setSpeciality(doctor.getSpeciality());
            
            return Optional.of(doctorRepository.save(updateDoctor));
        }

        return optionalDoctor;

    }

}
