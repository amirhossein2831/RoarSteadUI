package com.example.roarui.Models;

import com.example.roarui.Component.Annotations.ValidPassword;
import com.example.roarui.Component.Annotations.ValidUsername;
import com.example.roarui.Component.Validation.FormModel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class LoginForm implements FormModel<LoginForm> {

    private Set<ConstraintViolation<LoginForm>> violations = null;

    @ValidUsername
    private String username;

    @ValidPassword
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        this.violations = validator.validate(this);
        return this.violations.isEmpty();
    }

    @Override
    public Set<ConstraintViolation<LoginForm>> getViolations() {
        return this.violations;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
