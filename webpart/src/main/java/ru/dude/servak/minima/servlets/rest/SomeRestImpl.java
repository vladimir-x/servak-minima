package ru.dude.servak.minima.servlets.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

/**
 * Пример REST-сервиса
 * Вызывается адресом http://localhost:8080/xxx/webapi/rest/ping
 * Created by dude on 07.08.2017.
 */
@ApplicationScoped
@Path("/rest")
@ApplicationPath("/webapi")
public class SomeRestImpl extends Application implements SomeRest{

    @GET
    @Produces("text/html")
    @Path("/ping")
    public String ping() {
        return "<html lang=\"en\"><body><h1>Hello, I'm REST html!!</body></h1>"+this+"</html>";
    }
}
