package com.selesy.testing.junit5.extensions.disable.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(DisableRestExtension.class)
@Slf4j
public class DisableRestExceptionTests {

  @Test
  public void test() {
    log.trace("test()");
  }

  @DisableRest
  public void nonTest() {
    log.trace("nonTest()");
  }

}
