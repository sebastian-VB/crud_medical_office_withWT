package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.entities.User;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.repositories.UserRepository;


public class JpaUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> userOptional = userRepository.findByUsername(username);

        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema", username));
        }

        User user = userOptional.orElseThrow();

        List<GrantedAuthority> authorities = user.getRoles().stream().map(
            role -> new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.isEnabled(),
            true,
            true,
            true,
            authorities
        );
    }

}
