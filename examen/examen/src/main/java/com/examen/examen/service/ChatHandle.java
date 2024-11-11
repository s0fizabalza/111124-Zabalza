package com.examen.examen.service;
import ch.qos.logback.core.encoder.EchoEncoder;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service

public class ChatHandle extends TextWebSocketHandler {

    CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

    ArrayList<String> mensajes = new ArrayList<String>();
    ArrayList<PasswordAuthentication> contra = new ArrayList<PasswordAuthentication>();

    private static String mail ();
    private static final String CLAVE_CORR = "Ha inciado sesión" + mail + "al sv";

    ObjectMapper objectMapper = new ObjectMapper();

    @Override

    public void afterConnectionEstablished (WebSocketSession session) throws Exception {

        super.afterConnectionEstablished(session);
        sessions.add(session);
        for (String mensaje : mensajes) {

            session.sendMessage(new TextMessage(mensaje));

        }

    }

    @Override

    public void afterConnectionClosed (WebSocketSession session, CloseStatus close) throws Exception {
        super.afterConnectionClosed(session, close);
        sessions.remove(session);

    }

    @Override

    public void handleTextMessage (WebSocketSession session, PasswordAuthentication password ) throws Exception {

      PasswordAuthentication payload = password;

        if (payload .toString("123ABC")) {

            payload += "\n" + CLAVE_CORR;

        }else
            (payload.getUserName().toString()){
            payload += "";
        }

        mensajes.add(payload);

        for (WebSocketSession webSocketSession : sessions) {

            webSocketSession.sendMessage(new TextMessage(payload));

        }

    }

}