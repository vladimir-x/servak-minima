package ru.dude.servak.minima.beans.cdi;

/**
 * Created by dude on 08.10.2017.
 */
public class ProducedImpl implements SomeCDI {
    @Override
    public String test() {
        return "Hi, i'm ProducedImpl!" +this+"<br/>\n";
    }
}
