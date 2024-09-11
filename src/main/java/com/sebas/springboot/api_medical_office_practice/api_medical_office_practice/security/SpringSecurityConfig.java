package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.security.filter.JwtAuthenticationFilter;
import com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.security.filter.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((authz) -> authz
            .requestMatchers("/api/doctor").permitAll()
            .requestMatchers("/api/doctor/list").permitAll()
            .anyRequest().authenticated()
        )
            .addFilter(new JwtValidationFilter(authenticationManager()))
            .addFilter(new JwtAuthenticationFilter(authenticationManager()))
            .csrf(config -> config.disable())
            .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
    }

}
