package com.example.roarui.Component.Validation;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface FormModel<T> {
    public boolean validate();
    public Set<ConstraintViolation<T>> getViolations();
}
