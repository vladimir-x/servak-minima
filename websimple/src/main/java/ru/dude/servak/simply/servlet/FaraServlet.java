package ru.dude.servak.simply.servlet;

import org.apache.commons.lang.math.NumberUtils;

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


    public FaraServlet(){
        super();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<_fata_constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<_fata_init");
    }


    @Override
    public void destroy() {
        super.destroy();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<_fata_destroy");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("FaraServlet.doGet()");
        resp.getWriter().println("Hello! It's FaraServlet ");
        resp.getWriter().println("So simple");
        resp.getWriter().println("lib call: " + NumberUtils.max(1,2,3));
        resp.getWriter().println("That's all. bye!");
    }
}
