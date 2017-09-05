package com.selesy.testing.junit5.extensions.disable.rest;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

public class TrueConditionEvaluationPredicate implements ConditionEvaluationPredicate {
  
  static final String REASON = "This predicate always evaluates to true.";

  @Override
  public boolean test(String[] t) {
    return true;
  }
  
  @Override
  public String reason(String[] values) {
    return REASON;
  }

}
