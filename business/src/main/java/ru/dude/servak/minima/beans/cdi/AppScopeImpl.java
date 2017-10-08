package ru.dude.servak.minima.beans.cdi;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by dude on 06.10.2017.
 */

@ApplicationScoped
@Scopables(Scopes.APPLICATION)
public class AppScopeImpl implements  SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm AppScopeImpl!" +this +"<br/>\n";
    }
}
