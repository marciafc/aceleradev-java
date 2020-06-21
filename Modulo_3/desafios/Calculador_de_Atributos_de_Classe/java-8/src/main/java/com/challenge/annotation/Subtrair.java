package com.challenge.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(value = FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subtrair {
}
