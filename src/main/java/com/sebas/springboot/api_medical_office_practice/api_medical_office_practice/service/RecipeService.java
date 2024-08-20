package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;

public interface RecipeService {

    List<Recipe> findAll();

    Optional<Recipe> findById(Long id);

    Recipe save(Recipe recipe);

    Optional<Recipe> update(Recipe recipe, Long id);
}
