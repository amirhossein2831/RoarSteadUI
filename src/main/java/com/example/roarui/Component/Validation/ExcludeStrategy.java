package com.example.roarui.Component.Validation;

import com.example.roarui.Component.Annotations.Exclude;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ExcludeStrategy implements ExclusionStrategy  {
    @Override
    public boolean shouldSkipField(FieldAttributes field) {
        return field.getAnnotation(Exclude.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
