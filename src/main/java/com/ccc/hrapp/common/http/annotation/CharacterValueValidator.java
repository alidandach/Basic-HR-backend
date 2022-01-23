package com.ccc.hrapp.common.http.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CharacterValueValidator implements ConstraintValidator<CharacterValue, Character> {
    private boolean isRequired;

    @Override
    public void initialize(CharacterValue constraintAnnotation) {
        isRequired = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(Character characterValue, ConstraintValidatorContext constraintValidatorContext) {
        return !isRequired || characterValue != null;
    }
}
