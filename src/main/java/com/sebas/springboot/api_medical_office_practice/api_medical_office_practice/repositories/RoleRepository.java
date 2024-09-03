package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByName(String name);

}
