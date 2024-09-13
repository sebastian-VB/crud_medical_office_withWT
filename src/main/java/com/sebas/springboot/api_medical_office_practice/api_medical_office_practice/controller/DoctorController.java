package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.DoctorService;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.shared.MethodsForValidation;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> findOnlyDoctorById(@PathVariable Long id){

        Optional<Doctor> doctorOptional = doctorService.findById(id);

        if(doctorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(doctorOptional.get());
        }

        return ResponseEntity.notFound().build();
    }   

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createDoctor(@Valid @RequestBody Doctor doctor, BindingResult result){
        
        try {
            if(result.hasErrors()){
                return MethodsForValidation.validation(result);
            }
    
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctor));
        } catch (Exception e) {
            return MethodsForValidation.validationInService(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateDoctor(@Valid @RequestBody Doctor doctor, BindingResult result, @PathVariable Long id){

        try {
            
            if(result.hasErrors()){
                return MethodsForValidation.validation(result);
            }

            Optional<Doctor> optionalDoctor = doctorService.update(id, doctor);
            if(optionalDoctor.isPresent()){
                return ResponseEntity.status(HttpStatus.CREATED).body(optionalDoctor.orElseThrow());
            }
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            return MethodsForValidation.validationInService(e.getMessage());
        }


    }
}
