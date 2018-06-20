package ru.dude.servak.simply.servlet.cdi;

import javax.enterprise.context.Dependent;

/**
 * Created by dude on 06.10.2017.
 */

@Dependent
@Wireless
public class DependScopeImpl implements  SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm DependScopeImpl!" +this+"<br/>";
    }
}