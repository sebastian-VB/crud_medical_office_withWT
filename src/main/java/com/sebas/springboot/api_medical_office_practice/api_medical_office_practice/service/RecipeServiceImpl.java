package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Patient;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.DoctorRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.MedicineRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.PatientRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.RecipeRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.tdo.RecipeTDO;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Optional<Recipe> save(RecipeTDO recipeTdo) {
        
        Optional<Doctor> optionalDoctor = doctorRepository.findById(recipeTdo.getDoctor_id());
        Optional<Patient> optionalPatinent = patientRepository.findById(recipeTdo.getPatient_id());
        
        if(optionalDoctor.isPresent() && optionalPatinent.isPresent()){
            Recipe recipe = new Recipe();
            Set<Medicine> medicinesAux = new HashSet<>();
            
            recipe.setDoctor(optionalDoctor.orElseThrow());
            recipe.setPatient(optionalPatinent.orElseThrow());
            recipe.setDateReason(LocalDateTime.now());

            for(Medicine med: recipeTdo.getMedicines() ){
                if(!medicineRepository.existsByCode(med.getCode())){
                    medicineRepository.save(med);
                }
                medicinesAux.add(medicineRepository.findByCode(med.getCode()));
            }
            
            recipe.setMedicines(medicinesAux);

            return Optional.of(recipeRepository.save(recipe));
            // return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Recipe> update(Recipe recipe, Long id) {
        return Optional.empty();
    }

}
