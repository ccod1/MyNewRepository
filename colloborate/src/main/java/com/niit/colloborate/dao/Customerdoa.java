package com.niit.colloborate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloborate.model.Customer;


@Repository
@Transactional
public class Customerdoa {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void insertUser(Customer cust)
	{
		Session sess=sessionFactory.openSession();
		sess.save(cust);
		sess.flush();
		SQLQuery sq=sess.createSQLQuery("insert into user_authorization values(2,'"+cust.getCust_id()+"','ROLE_USER')");
		sq.executeUpdate();
	}
	
	public boolean login(String un,String pass)
	{
		boolean b=false;
		
		Session sess=sessionFactory.openSession();
		Criteria c=sess.createCriteria(Customer.class);
		c.add(Restrictions.and(Restrictions.eq("username", un), Restrictions.eq("password", pass)));
		List<Customer>l=c.list();
		if(l.isEmpty())
			b=false;
		else
			b=true;
			
		return b;
	}
}
