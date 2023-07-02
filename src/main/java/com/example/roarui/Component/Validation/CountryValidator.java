package com.example.roarui.Component.Validation;

import com.example.roarui.Component.Annotations.ValidCountry;
import com.example.roarui.Models.Country;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<ValidCountry, String> {
    @Override
    public void initialize(ValidCountry constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(String dialCode, ConstraintValidatorContext context) {
        if (dialCode == null) {
            return false;  // null values are considered invalid
        }

        // Validation logic for the Country object
       return Country.getCountryByDialCode(dialCode) != null;
    }
}
