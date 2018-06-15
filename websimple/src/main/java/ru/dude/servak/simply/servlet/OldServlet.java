package ru.dude.servak.simply.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladimirx
 * Date: 15.06.18
 */
@Deprecated
public class OldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("OldServlet.doGet()");
        resp.getWriter().println("Hello! It's OldServlet ");
        resp.getWriter().println("That's all. bye!");
    }
}
