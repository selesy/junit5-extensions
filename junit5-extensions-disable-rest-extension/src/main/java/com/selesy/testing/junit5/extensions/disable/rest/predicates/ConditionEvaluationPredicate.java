package com.selesy.testing.junit5.extensions.disable.rest.predicates;

import java.util.function.Predicate;

@FunctionalInterface
public interface ConditionEvaluationPredicate extends Predicate<String[]> {
  
  default String reason(String[] values) {
    return String.join(", ", values);
  }

}
