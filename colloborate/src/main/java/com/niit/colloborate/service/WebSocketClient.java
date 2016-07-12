package com.niit.colloborate.service;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@ServerEndpoint("/echo")
public class WebSocketClient {
	
	
	public WebSocketClient(){
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Autowired
	ChatMessageService chatservice;
	
	 @OnMessage
	    public void echoTextMessage(Session session, String msg, boolean last) {
	        try {
	        	
	            if (session.isOpen()) {
	            	System.out.println("Im inside echotext");
	            	System.out.println(msg);
	            	String arr[]=msg.split(":");
	            	System.out.println(arr[0]);
	            	System.out.println(chatservice);
	            	chatservice.inserMessage(arr[1], arr[0]);
	            	
	                session.getBasicRemote().sendText(arr[0], last);
	            }
	        } catch (IOException e) {
	            try {
	            	e.printStackTrace();
	                session.close();
	            } catch (IOException e1) {
	                // Ignore
	            }
	        }
	    }


}
