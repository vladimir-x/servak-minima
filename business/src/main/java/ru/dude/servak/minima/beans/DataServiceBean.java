package ru.dude.servak.minima.beans;

import ru.dude.servak.minima.beans.cdi.ProducedImpl;
import ru.dude.servak.minima.beans.cdi.Scopables;
import ru.dude.servak.minima.beans.cdi.Scopes;
import ru.dude.servak.minima.beans.cdi.SomeCDI;
import ru.dude.servak.minima.beans.entites.User;
import ru.dude.servak.minima.beans.entites.User_;
import ru.dude.servak.minima.beans.interfaces.DataService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by dude on 05.08.2017.
 */
@Stateless
public class DataServiceBean implements DataService{


    @PersistenceContext
    EntityManager em;

    @Inject
    @Scopables(Scopes.APPLICATION)
    SomeCDI appCDI;

    @Inject @Scopables(Scopes.SESSION)
    SomeCDI sessionCDI;

    @Inject @Scopables(Scopes.REQUEST)
    SomeCDI requestCDI;

    @Inject @Scopables(Scopes.DEPENDS)
    SomeCDI dependsCDI;

    @Inject
    ProducedImpl producedCDI;



    public String pingBean() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Hello! I'm @Stateless bean DataServiceBean, and i want to get some DBData...<br/>");

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> from = query.from(User.class);

        //ru.dude.servak.minima.beans.entites.User_;


        Integer k = 74;
        String f = "%asdsd";
       // query.where(builder.isNotNull(from.get(User_.id)));
        query.where(builder.like(from.get(User_.name),f));

        List<User> userList = em.createQuery(query).getResultList();

        sb.append("<br/> And the are "  + userList.size() + " users in bd.<br/>");


        sb.append("And  now i show you some Injection component from CMT:<br/>");
        sb.append(appCDI.test());
        sb.append(sessionCDI.test());
        sb.append(requestCDI.test());
        sb.append(dependsCDI.test());
        sb.append(producedCDI.test());
        sb.append( "bye....<br/>");

        return sb.toString();
    }
}
