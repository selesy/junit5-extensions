package com.selesy.testing.junit5.extensions.disable.rest;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Repeatable(DisabledIfs.class)
@ExtendWith(DisabledIfExtension.class)
public @interface DisabledIf {

  Class<? extends ConditionEvaluationPredicate> value();
  String[] arguments() default {};

}
