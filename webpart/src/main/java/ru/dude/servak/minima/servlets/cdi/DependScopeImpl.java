package ru.dude.servak.minima.servlets.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 * Created by dude on 06.10.2017.
 */

@Dependent
@Scopables(Scopes.DEPENDS)
public class DependScopeImpl implements  SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm DependScopeImpl!" +this+"<br/>";
    }
}