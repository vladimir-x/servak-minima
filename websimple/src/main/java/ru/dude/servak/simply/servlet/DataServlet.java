package ru.dude.servak.simply.servlet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vladimirx
 * Date: 15.06.18
 */
@WebServlet(name="DataServlet", urlPatterns={"/data"})
public class DataServlet extends HttpServlet {

    DataSource ds;


    @Override
    public void init() throws ServletException {
        try {
            initDB();
        } catch (Exception e) {
            throw  new ServletException(e);
        }
    }

    private void initDB() throws Exception{
        InitialContext cxt = new InitialContext();
        if ( cxt == null ) {
            throw new Exception("Uh oh -- no context!");
        }

        ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres" );

        if ( ds == null ) {
            throw new Exception("Data source not found!");
        }

        System.out.println("Data source init COMPLETE!");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DataServlet.doGet()");
        resp.getWriter().println("Hello! It's DataServlet ");
        if (ds !=null){
            try {
                Connection c = ds.getConnection();
                String sql = "select count(*)  from pg_catalog.pg_roles";
                try(ResultSet resultSet = c.createStatement().executeQuery(sql)) {

                    if (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                        resp.getWriter().println("DB work is good!");
                    }
                }

            } catch (SQLException e) {
                resp.getWriter().println("DB work error!");
                e.printStackTrace();
            }
        }

        resp.getWriter().println("That's all. bye!");
    }
}
