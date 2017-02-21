/**
 * 
 */
package com.selesy.testing.junit5.extensions.disable.rest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author swm16
 *
 */
@Slf4j
public class DisableRestExtension implements TestExecutionCondition {

  static final String DISABLE_REST_KEY = "DISABLED_REST_FLAG";

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.TestExecutionCondition#evaluate(org.junit.
   * jupiter.api.extension.TestExtensionContext)
   */
  // @Override
  @Override
  @NonNull
  public ConditionEvaluationResult evaluate(@NonNull TestExtensionContext context) {
    log.trace("evaluate(TestExtensionContext)");
    return context.getParent()
        .filter(this::hasDisableRest)
        .map(ExtensionContext::getTestMethod)
        .map(this::evaluate)
        .orElse(ConditionEvaluationResult.enabled(""));

  }

  @NonNull
  ConditionEvaluationResult evaluate(@NonNull Optional<Method> method) {
    log.trace("evaluate(Optional<Method>)");
    return method
        .filter(m -> m.isAnnotationPresent(DisableRest.class))
        .map(m -> ConditionEvaluationResult.enabled(""))
        .orElse(ConditionEvaluationResult.disabled("Another test is marked with @DisableRest"));
  }

  boolean hasDisableRest(ExtensionContext context) {
    log.trace("hasDisableRest(ExtensionContext)");
    Namespace namespace = Namespace.create(context.getUniqueId());
    Store store = context.getStore(namespace);
    return store
        .getOrComputeIfAbsent(DISABLE_REST_KEY, key -> isDisableRestWithin(context.getTestClass()), Boolean.class);
  }

  boolean isDisableRestWithin(@NonNull Optional<Class<?>> optionalTestClass) {
    log.trace("isDisableRestWithin(Optional<Class<?>>)");
    return optionalTestClass
        .map(c -> isAnnotationWithin(c, DisableRest.class))
        .orElse(false);
  }

  boolean isAnnotationWithin(@NonNull Class<?> testClass, @NonNull Class<? extends Annotation> annotationClass) {
    log.trace("isAnnotationWithin(Class<?>, Class<? extends Annotation");
    return Stream.of(testClass.getMethods())
        .filter(m -> m.isAnnotationPresent(Test.class))
        .map(m -> m.isAnnotationPresent(annotationClass))
        .findFirst()
        .orElse(false);
  }

}
