package com.medical_records.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class TitleValidator implements ConstraintValidator<ValidTitle, String> {
    private static final Set<String> VALID_TITLES = Set.of("Mr.", "Mrs.", "Dr.", "Ms.");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && VALID_TITLES.contains(value);
    }
}
