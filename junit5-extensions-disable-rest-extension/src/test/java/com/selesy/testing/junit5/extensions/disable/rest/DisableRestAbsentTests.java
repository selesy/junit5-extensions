package com.selesy.testing.junit5.extensions.disable.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(DisableRestExtension.class)
@Slf4j
public class DisableRestAbsentTests {

  // @formatter:off
  @Test public void test1() { log.trace("test1"); }
  @Test public void test2() { log.trace("test2"); }
  @Test public void test3() { log.trace("test3"); }
  @Test public void test4() { log.trace("test4"); }
  // @formatter:on

}
