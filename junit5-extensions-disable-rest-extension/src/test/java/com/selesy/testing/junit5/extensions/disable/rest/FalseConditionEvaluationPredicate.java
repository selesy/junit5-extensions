package com.selesy.testing.junit5.extensions.disable.rest;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

public class FalseConditionEvaluationPredicate implements ConditionEvaluationPredicate {
  
  static final String REASON = "This predicate always evaluates to false.";

  @Override
  public boolean test(String[] t) {
    return false;
  }
  
  @Override
  public String reason(String[] values) {
    return REASON;
  }

}
