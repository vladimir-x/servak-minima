package ru.dude.servak.simply.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * Created by dude on 06.10.2017.
 */
@RequestScoped
public class AppScopeImpl implements Serializable ,SomeCDI  {
    @Override
    public String test() {
        return "Hi, i'm some impl!" +this;
    }
}
