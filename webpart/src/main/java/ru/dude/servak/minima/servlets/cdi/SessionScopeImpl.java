package ru.dude.servak.minima.servlets.cdi;

import javax.enterprise.context.SessionScoped;

/**
 * Created by dude on 06.10.2017.
 */

@SessionScoped
@Scopables(Scopes.SESSION)
public class SessionScopeImpl implements  SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm SessionScopeImpl!" +this+"<br/>";
    }
}