package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.Role;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.User;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.RoleRepository;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        
        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        // optionalRole.ifPresent(role -> roles.add(role));
        optionalRole.ifPresent(roles::add);

        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

}
