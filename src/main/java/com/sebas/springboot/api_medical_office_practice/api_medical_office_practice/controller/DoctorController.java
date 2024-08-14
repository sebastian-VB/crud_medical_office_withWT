package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOnlyDoctorById(@PathVariable Long id){

        Optional<Doctor> doctorOptional = doctorService.findById(id);

        if(doctorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(doctorOptional.get());
        }

        return ResponseEntity.notFound().build();
    }   

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }
}
