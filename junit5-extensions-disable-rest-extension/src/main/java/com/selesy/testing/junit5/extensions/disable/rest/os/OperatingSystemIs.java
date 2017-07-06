package com.selesy.testing.junit5.extensions.disable.rest.os;

import java.util.stream.Stream;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

public class OperatingSystemIs implements ConditionEvaluationPredicate {

  @Override
  public boolean test(String[] values) {
    String os = (System.getProperty("os.name", "")).toLowerCase();
    return Stream.of(values)
        .map(String::toLowerCase)
        .filter(os::equals)
        .findFirst().isPresent();
  }

  @Override
  public String reason(String[] values) {
    return "The os.name system property did not match value: " + values;
  }

}
