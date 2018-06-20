package ru.dude.servak.simply.servlet;

import ru.dude.servak.simply.servlet.cdi.Wireless;
import ru.dude.servak.simply.servlet.cdi.SomeCDI;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladimirx
 * Date: 20.06.18
 */
@WebServlet(name="CDIServlet", urlPatterns={"/cdi"})
public class CDIServlet extends HttpServlet {

    @Inject
    @Wireless
    SomeCDI dependsCDI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("CDIServlet.doGet()");
        resp.getWriter().println("Hello! It's CDIServlet ");
        resp.getWriter().println("dependsCDI = " + dependsCDI);
        if (dependsCDI!=null) {
            resp.getWriter().println("dependsCDI.call() = " + dependsCDI.test());
        }
        resp.getWriter().println("That's all. bye!");
    }


}
