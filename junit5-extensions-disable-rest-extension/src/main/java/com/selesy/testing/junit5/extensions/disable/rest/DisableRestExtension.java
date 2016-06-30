/**
 * 
 */
package com.selesy.testing.junit5.extensions.disable.rest;

import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author swm16
 *
 */
@Slf4j
public class DisableRestExtension implements TestExecutionCondition {

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.junit.jupiter.api.extension.TestExecutionCondition#evaluate(org.junit.
   * jupiter.api.extension.TestExtensionContext)
   */
  @Override
  public ConditionEvaluationResult evaluate(TestExtensionContext context) {
    log.trace("evaluate()");
    ConditionEvaluationResult result = ConditionEvaluationResult.enabled("");

    Optional<ExtensionContext> optionalParent = context.getParent();
    if (optionalParent.isPresent()) {
      ExtensionContext parent = optionalParent.get();
      Namespace namespace = Namespace.create(parent.getUniqueId());
      Store store = parent.getStore(namespace);

      boolean disabledRestPresent = (Boolean) store.getOrComputeIfAbsent("DISABLED_REST_FLAG",
          (key) -> hasDisableRest(context.getTestClass()));
      log.debug("Has @DisableRest in class: {}", disabledRestPresent);

      if (disabledRestPresent) {
        Optional<Method> optionalTestMethod = context.getTestMethod();
        if (optionalTestMethod.isPresent()) {
          Method testMethod = optionalTestMethod.get();
          if (!testMethod.isAnnotationPresent(DisableRest.class)) {
            result = ConditionEvaluationResult.disabled("Another test is marked with @DisableRest");
          }
        }
      }

      log.debug("Has @DisableRest on method: {}", disabledRestPresent && !result.isDisabled());
    }

    log.debug("@Test will run: {}", !result.isDisabled());

    return result;
  }

  boolean hasDisableRest(Optional<Class<?>> optionalTestClass) {
    log.trace("hasDisableRest()");
    boolean disabledRestPresent = false;

    if (optionalTestClass.isPresent()) {
      Class<?> testClass = optionalTestClass.get();
      for (Method method : testClass.getMethods()) {
        if (method.isAnnotationPresent(DisableRest.class)) {
          if (method.isAnnotationPresent(Test.class)) {
            disabledRestPresent = true;
          }
        }
      }
    }

    return disabledRestPresent;
  }

}
