package com.selesy.testing.junit5.extensions.disable.rest.os;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import com.selesy.testing.junit5.extensions.disable.rest.DisabledIf;
import com.selesy.testing.junit5.extensions.disable.rest.DisabledIfExtension;

@Retention(RUNTIME)
@Target({ METHOD, TYPE })
@ExtendWith(DisabledIfExtension.class)
@DisabledIf(predicate = OperatingSystemIs.class, arguments = "Linux")
public @interface DisabledIfOperatingSystemIsLinux {

}
