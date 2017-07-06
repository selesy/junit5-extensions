package com.selesy.testing.junit5.extensions.disable.rest;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@ExtendWith(DisabledIfExtension.class)
public @interface DisabledIfs {
  
  DisabledIf[] value();

}
