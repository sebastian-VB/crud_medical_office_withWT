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

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.MedicineService;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.shared.MethodsForValidation;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Medicine> findAll(){
        return medicineService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        
        Optional<Medicine> optionalMedicine = medicineService.findById(id);

        if(optionalMedicine.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalMedicine.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> save(@Valid @RequestBody Medicine medicine, BindingResult result){

        if(result.hasErrors()){
            return MethodsForValidation.validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(medicineService.save(medicine));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @RequestBody Medicine medicine, BindingResult result, @PathVariable Long id){
        
        if(result.hasErrors()){
            return MethodsForValidation.validation(result);
        }

        Optional<Medicine> optionalMedicine = medicineService.update(medicine, id);

        if(optionalMedicine.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalMedicine.orElseThrow());
        }

        return ResponseEntity.notFound().build();
        
    }
}
