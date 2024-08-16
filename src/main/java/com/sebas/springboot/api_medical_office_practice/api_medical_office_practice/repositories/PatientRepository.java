package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    /*
     * METODO PRA GUARDAR
     * METODO PARA LISTAR
     * --METODO PARA OBTENER UN PCIENTE POR NOMBRE(USANDO QUERY)
     * --METODO PARA LISTAR PACIENTES POR FECHA(USANDO QUERY)
     * METODO PARA ACTUALIZAR
     * METODO PARA ELIMINAR
     */
}
