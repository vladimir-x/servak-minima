package ru.dude.servak.minima.beans.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 * Created by dude on 08.10.2017.
 */
@ApplicationScoped
public class CdiFabric {

    @Produces @RequestScoped
    public ProducedImpl createProducedImpl(){
        return new ProducedImpl();
    }
}
