package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe save(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Recipe> update(Recipe recipe, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
