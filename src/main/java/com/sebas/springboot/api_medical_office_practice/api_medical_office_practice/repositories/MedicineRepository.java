package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

    /*
     * METODO PRA GUARDAR
     * METODO PARA LISTAR
     * --METODO PARA OBTENER UN MEDICAMENTO POR NOMBRE(USANDO QUERY)
     * --METODO PARA CONSULTAR POR CODIGO SI EXISTE ESA MEDICINA
     * METODO PARA ACTUALIZAR
     * METODO PARA ELIMINAR
     */

    Medicine findByCode(String code);

    boolean existsByCode(String code);
}
