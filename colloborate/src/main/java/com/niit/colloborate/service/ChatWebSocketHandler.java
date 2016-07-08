package com.niit.colloborate.service;

/*import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket*/
public class ChatWebSocketHandler {
/*
    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        String username = "User" + ChatProcess.nextUserNumber++;
        ChatProcess.userUsernameMap.put(user, username);
        ChatProcess.broadcastMessage(sender = "Server", msg = (username + " joined the chat"));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        String username = ChatProcess.userUsernameMap.get(user);
        ChatProcess.userUsernameMap.remove(user);
        ChatProcess.broadcastMessage(sender = "Server", msg = (username + " left the chat"));
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
    	ChatProcess.broadcastMessage(sender = ChatProcess.userUsernameMap.get(user), msg = message);
    }
*/
}