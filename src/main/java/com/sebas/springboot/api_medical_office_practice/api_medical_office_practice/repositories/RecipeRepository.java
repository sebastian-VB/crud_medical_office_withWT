package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

    /*
     * METODO PRA GUARDAR
     * METODO PARA LISTAR
     * --METODO PARA OBTENER UN LISTADO DE RECETAS (O UNA RECETA) POR DOCTOR - POR NOMBRE O ID(USANDO QUERY)
     * --METODO PARA OBTENER UN LISTADO DE RECETAS (O UNA RECETA) POR PACIENTE - POR NOMBRE O ID(USANDO QUERY - creo)
     * METODO PARA ACTUALIZAR
     * METODO PARA ELIMINAR
     */
}
