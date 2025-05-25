package com.medical_records.validation;

import com.medical_records.dto.RegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterDTO> {

    @Override
    public boolean isValid(RegisterDTO request, ConstraintValidatorContext context) {
        if (request.getPassword() == null || request.getConfirmPassword() == null) {
            return false;
        }
        boolean matched = request.getPassword().equals(request.getConfirmPassword());

        if (!matched) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return matched;
    }
}
