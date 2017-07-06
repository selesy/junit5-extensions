package com.selesy.testing.junit5.extensions.disable.rest;

import java.lang.reflect.AnnotatedElement;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

public class DisabledIfExtension implements ExecutionCondition {

  static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("");

  /*
   * (non-Javadoc)
   * 
   * @see org.junit.jupiter.api.extension.ExecutionCondition#evaluateExecutionCondition(org.junit.jupiter.api.extension.ExtensionContext)
   */
  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    return context.getElement()
        .map(this::evaluate)
        .orElse(ENABLED);
  }

  ConditionEvaluationResult evaluate(AnnotatedElement element) {
    return Stream.of(element.getAnnotationsByType(DisabledIf.class))
        .map(this::evaluate)
        .findFirst()
        .orElse(ENABLED);
  }

  ConditionEvaluationResult evaluate(DisabledIf annotation) {
    try {
      ConditionEvaluationPredicate predicate = annotation.value().newInstance();
      if (predicate.test(annotation.arguments())) {
        return ConditionEvaluationResult.disabled(predicate.reason(annotation.arguments()));
      }
    } catch (InstantiationException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return ENABLED;
  }

}
