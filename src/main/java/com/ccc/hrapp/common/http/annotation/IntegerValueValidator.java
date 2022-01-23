package com.ccc.hrapp.common.http.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerValueValidator implements ConstraintValidator<IntegerValue, Integer> {
    private boolean isRequired;

    @Override
    public void initialize(IntegerValue constraintAnnotation) {
        isRequired = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return !isRequired || integer != null;
    }
}
