package ru.dude.servak.minima.beans.interfaces;

import javax.ejb.Local;

/**
 * Created by dude on 05.08.2017.
 */
@Local
public interface DataService {

    String pingBean();
}
