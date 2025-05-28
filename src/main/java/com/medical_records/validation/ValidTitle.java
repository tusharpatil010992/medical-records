package com.medical_records.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TitleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTitle {
    String message() default "Invalid title. Must be one of: Mr., Mrs., Dr., Ms.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
