package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}
