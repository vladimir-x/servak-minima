package ru.dude.servak.simply.servlet;

import ru.dude.servak.simply.cdi.SomeCDI;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dude on 06.10.2017.
 */

@WebServlet(name="FaraServlet", urlPatterns={"/fara"})
public class FaraServlet extends HttpServlet {


    @Inject
    SomeCDI appScope;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FaraServlet.doGet()");
        resp.getWriter().println("Hello! It's FaraServlet");
        resp.getWriter().println(appScope.test());
        resp.getWriter().println("That's all. bye!");
    }
}
