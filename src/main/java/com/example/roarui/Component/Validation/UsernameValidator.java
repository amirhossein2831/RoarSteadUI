package com.example.roarui.Component.Validation;

import com.example.roarui.Component.Annotations.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private static final String USERNAME_PATTERN = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null) {
            return false;  // null values are considered invalid
        }
        // Validate the username using the pattern
        return username.matches(USERNAME_PATTERN);
    }
}
