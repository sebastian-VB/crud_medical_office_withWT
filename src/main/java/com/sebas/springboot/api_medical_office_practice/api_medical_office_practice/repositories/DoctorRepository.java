package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

    /*
     * METODO PRA GUARDAR
     * METODO PARA LISTAR
     * --METODO PARA OBTENER UN DOCTOR POR NOMBRE(USANDO QUERY)
     * --METODO PARA LISTAR DOCOTRES POR ESPECIALIDAD(USANDO QUERY)
     * METODO PARA ACTUALIZAR
     * METODO PARA ELIMINAR
     */

}
