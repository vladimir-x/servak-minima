package ru.dude.servak.minima.servlets;

import ru.dude.servak.minima.beans.interfaces.DataService;
import ru.dude.servak.minima.servlets.cdi.Scopables;
import ru.dude.servak.minima.servlets.cdi.Scopes;
import ru.dude.servak.minima.servlets.cdi.SomeCDI;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dude on 05.08.2017.
 */
@WebServlet(name="FrontServlet", urlPatterns={"/front"})
public class FrontServlet extends HttpServlet {

    @EJB
    DataService dataService;

    @Inject @Scopables(Scopes.APPLICATION)
    SomeCDI appCDI;

    @Inject @Scopables(Scopes.SESSION)
    SomeCDI sessionCDI;

    @Inject @Scopables(Scopes.REQUEST)
    SomeCDI requestCDI;

    @Inject @Scopables(Scopes.DEPENDS)  //в данном случае как у сервлета, т.е. @ApplicationScoped
    SomeCDI dependsCDI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontServlet.doGet()");
        resp.getWriter().println("Hello! It's FrontServlet, and now i'm show ypu Ejb calling..");
        resp.getWriter().println(dataService.pingBean());
        resp.getWriter().println(appCDI.test());
        resp.getWriter().println(sessionCDI.test());
        resp.getWriter().println(requestCDI.test());
        resp.getWriter().println(dependsCDI.test());

     //   resp.getWriter().println(req.getSession());

        resp.getWriter().println("That's all. bye!");
    }
}
