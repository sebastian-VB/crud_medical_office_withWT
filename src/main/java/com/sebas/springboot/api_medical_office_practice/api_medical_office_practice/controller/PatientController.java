package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Patient;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public List<Patient> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Patient> optionalPatient = patientService.findById(id);

        if(optionalPatient.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalPatient.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Long id){

        Optional<Patient> optinalPatient = patientService.update(id, patient);

        if(optinalPatient.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optinalPatient.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
}
