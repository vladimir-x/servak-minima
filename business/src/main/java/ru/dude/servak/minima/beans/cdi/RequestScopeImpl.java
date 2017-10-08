package ru.dude.servak.minima.beans.cdi;

import javax.enterprise.context.RequestScoped;

/**
 * Created by dude on 06.10.2017.
 */

@RequestScoped
@Scopables(Scopes.REQUEST)
public class RequestScopeImpl implements  SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm RequestScopeImpl!" +this+"<br/>";
    }
}