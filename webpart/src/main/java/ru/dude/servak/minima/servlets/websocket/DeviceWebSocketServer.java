package ru.dude.servak.minima.servlets.websocket;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.StringReader;

/**
 * Пример работы с вэб-сокетами
 * Created by dude on 05.10.2017.
 */
@ApplicationScoped
@ServerEndpoint("/actions")
public class DeviceWebSocketServer {

    @Inject
    private DeviceSessionHandler sessionHandler;

    @OnOpen
    public void open(Session session) {
        sessionHandler.addSession(session);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {

        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();

            if ("add".equals(jsonMessage.getString("action"))) {
                Device device = new Device();
                device.setName(jsonMessage.getString("name"));
                device.setDescription(jsonMessage.getString("description"));
                device.setType(jsonMessage.getString("type"));
                device.setStatus("Off");
                sessionHandler.addDevice(device);
            }

            if ("remove".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.removeDevice(id);
            }

            if ("toggle".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.toggleDevice(id);
            }
        }
    }

    @OnClose
    public void close(Session session) {
        sessionHandler.removeSession(session);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println(error);
    }

}