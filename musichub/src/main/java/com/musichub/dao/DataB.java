package com.musichub.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musichub.model.UserDetails;

@Repository
public class DataB {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(UserDetails us)
	{
		Session s=sessionFactory.openSession();
		s.save(us);
		s.flush();
	}
}
