package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.security;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;

public class TokenConfig {

    public static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_ATHORIZATION = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
}
