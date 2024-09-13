package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service.RecipeService;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.shared.MethodsForValidation;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.tdo.RecipeTDO;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Recipe> findAll(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Recipe> optionalRecipe = recipeService.findById(id);

        if(optionalRecipe.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalRecipe.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> save(@RequestBody RecipeTDO recipeTdo){

        try {
            Optional<Recipe> optionalRecipe = recipeService.save(recipeTdo);
            return ResponseEntity.status(HttpStatus.OK).body(optionalRecipe.orElseThrow());
            
        } catch (Exception e) {
            return MethodsForValidation.validationInService(e.getMessage());
        }

        
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> update(@RequestBody RecipeTDO recipeTDO, @PathVariable Long id){

        try {
            Optional<Recipe> recipeOptional= recipeService.update(recipeTDO, id);
            return ResponseEntity.status(HttpStatus.OK).body(recipeOptional.orElseThrow());

        } catch (Exception e) {
            return MethodsForValidation.validationInService(e.getMessage());
        }

        
    }

}
