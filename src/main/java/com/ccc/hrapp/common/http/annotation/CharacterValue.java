package com.ccc.hrapp.common.http.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = CharacterValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CharacterValue {
    boolean isRequired();

    String message() default "Invalid character value";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
