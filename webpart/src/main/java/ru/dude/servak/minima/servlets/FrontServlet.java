package ru.dude.servak.minima.servlets;

import ru.dude.servak.minima.beans.interfaces.DataService;

import javax.ejb.EJB;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontServlet.doGet()");
        resp.getWriter().println("Hello! It's FrontServlet, and now i'm show ypu Ejb calling..");
        resp.getWriter().println(dataService.pingBean());
        resp.getWriter().println("That's all. bye!");
    }
}
