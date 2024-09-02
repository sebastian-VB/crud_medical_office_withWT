package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByDniValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByDni {

    String message() default "digite un nuevo DNI";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
