package com.ccc.hrapp.common.http.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValueValidator implements ConstraintValidator<StringValue, String> {
    private boolean isRequired;

    @Override
    public void initialize(StringValue constraintAnnotation) {
        isRequired = constraintAnnotation.isRequired();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (isRequired) {
            return value != null && !value.trim().equals("");
        }
        return true;
    }
}
