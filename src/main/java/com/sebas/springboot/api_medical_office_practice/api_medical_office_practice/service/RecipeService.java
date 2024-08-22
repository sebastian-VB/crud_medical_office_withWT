package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.tdo.RecipeTDO;

public interface RecipeService {

    List<Recipe> findAll();

    Optional<Recipe> findById(Long id);

    Optional<Recipe> save(RecipeTDO recipe);

    Optional<Recipe> update(RecipeTDO recipe, Long id);
}
