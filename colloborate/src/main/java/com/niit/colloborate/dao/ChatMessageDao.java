package com.niit.colloborate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloborate.model.ChatMessage;

@Repository
public class ChatMessageDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void insertMessage(String sender,String msg)
	{
		Session sess=sessionFactory.openSession();
		ChatMessage cm=new ChatMessage();
		cm.setSender(sender);
		cm.setMessage(msg);
		System.out.println("Message inserted on  "+cm.getReceivedOn());
		sess.save(cm);
		sess.flush();
				
	}

}
