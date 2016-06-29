package com.selesy.testing.junit5.extensions.disable.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(DisableRestExtension.class)
@Slf4j
public class DisableRestPresentTests {

  // @formatter:off
  @Test public void test1() { log.trace("test1"); fail("This test should not be run."); }
  @Test @DisableRest public void test2() { log.trace("test2"); }
  @Test public void test3() { log.trace("test3"); fail("This test should not be run."); }
  @Test public void test4() { log.trace("test4"); fail("This test should not be run."); }
  // @formatter:on

}
