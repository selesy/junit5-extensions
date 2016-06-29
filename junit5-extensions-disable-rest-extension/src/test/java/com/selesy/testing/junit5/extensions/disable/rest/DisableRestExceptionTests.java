package com.selesy.testing.junit5.extensions.disable.rest;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(DisableRestExtension.class)
@Slf4j
public class DisableRestExceptionTests {

  @Test
  public void test() {
    log.trace("test()");
//    fail("This test should not be run.");
  }

// TODO - Figure out how to test that an exception is thrown if this test is included
//  @DisableRest
//  public void nonTest() {
//    log.trace("nonTest()");
//  }

}
