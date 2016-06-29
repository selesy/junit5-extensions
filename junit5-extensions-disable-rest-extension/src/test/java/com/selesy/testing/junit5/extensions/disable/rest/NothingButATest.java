package com.selesy.testing.junit5.extensions.disable.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(DisableRestExtension.class)
public class NothingButATest {

  @Test
  public void testNothing() {

  }

}
