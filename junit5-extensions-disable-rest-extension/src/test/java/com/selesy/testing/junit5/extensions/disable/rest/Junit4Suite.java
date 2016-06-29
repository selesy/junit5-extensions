package com.selesy.testing.junit5.extensions.disable.rest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.runner.SelectPackages;
import org.junit.runner.RunWith;

/**
 * Uses JUnit5's pseudo-runner to define a suite of tests that can be run using
 * JUnit4.
 * 
 * @author Steve Moyer &lt;smoyer1@selesy.com&gt;
 */
@RunWith(JUnitPlatform.class)
@SelectPackages("com.selesy.testing.junit5.extensions.disable.rest")
public class Junit4Suite {

}
