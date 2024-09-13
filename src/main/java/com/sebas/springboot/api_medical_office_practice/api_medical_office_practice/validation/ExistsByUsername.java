package com.sebas.springboot.api_medical_office_practice.api_medical_office_practice.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByUsername {

    String message() default "digite un nuevo Username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
