package com.example.SocailMedia.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Passwords.class)
public @interface Password {
    public String message() default "Invalid Password Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
