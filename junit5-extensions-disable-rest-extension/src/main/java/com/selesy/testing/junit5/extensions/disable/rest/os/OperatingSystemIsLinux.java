/**
 * 
 */
package com.selesy.testing.junit5.extensions.disable.rest.os;

/**
 * @author swm16
 *
 */
public class OperatingSystemIsLinux extends OperatingSystemIs {
  
  @Override
  public boolean test(String[] value) {
    String[] values = { "linux" };
    return super.test(values);
  }

}
