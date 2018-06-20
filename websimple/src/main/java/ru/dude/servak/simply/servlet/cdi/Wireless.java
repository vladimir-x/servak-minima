package ru.dude.servak.simply.servlet.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dude on 06.10.2017.
 */
@Target({ METHOD, TYPE, FIELD })
@Retention(RUNTIME)
@Qualifier
public @interface Wireless {


}
