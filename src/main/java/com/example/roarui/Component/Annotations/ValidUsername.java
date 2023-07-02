package com.example.roarui.Component.Annotations;

import com.example.roarui.Component.Validation.UsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {
    String message() default "Invalid username: ${validatedValue}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
