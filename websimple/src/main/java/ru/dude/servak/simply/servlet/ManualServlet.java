package ru.dude.servak.simply.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Для ручного подкладывания
 * Created by vladimirx
 * Date: 20.06.18
 */
@WebServlet(name="ManualServlet", urlPatterns={"/manual"})
public class ManualServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("ManualServlet.doGet()");
        resp.getWriter().println("Hello! It's ManualServlet 4 ");
        resp.getWriter().println("That's all. bye!");
    }
}

