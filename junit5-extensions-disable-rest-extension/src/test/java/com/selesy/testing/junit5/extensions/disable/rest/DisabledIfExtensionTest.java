package com.selesy.testing.junit5.extensions.disable.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.selesy.testing.junit5.extensions.disable.rest.predicates.ConditionEvaluationPredicate;

@ExtendWith(DisabledIfExtension.class)
public class DisabledIfExtensionTest {
  
  ConditionEvaluationPredicate truePredicate = values -> true;
  ConditionEvaluationPredicate falsePredicate = values -> false;
  
  @Test
  @DisabledIf(TrueConditionEvaluationPredicate.class)
  void testThatIsDisabledByTruePredicate() {
    fail("This test should not have run");
  }
  
  @Test
  @DisabledIf(FalseConditionEvaluationPredicate.class)
  void testThatIsNotDisabledByFalsePredicate() {
    
  }
  
//  @Test
//  @DisabledIf(predicate = OperatingSystemIs.class, value="Windows")
//  public void testUnderWindows() {
//    
//  }
//  
//  @Test
//  @DisabledIf(predicate = OperatingSystemIs.class, value="Linux")
//  public void testUnderLinux1() {
//    fail("This test should not run on Linux");
//  }
//  
//  @Test
//  @Disabled
//  @DisabledIfOperatingSystemIsLinux
//  public void testUnderLinux2() {
//    fail("This test should not run on Linux");
//  }
//  
//  @Test
//  @Disabled
//  @DisabledIf(predicate = OperatingSystemIsLinux.class)
//  public void testUnderLinux3() {
//    fail("This test should not run on Linux");
//  }
//  
//  @Test
//  public void test2() {
//    
//  }

}
