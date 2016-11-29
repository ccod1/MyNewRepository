package com.niit.colloboratebackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.colloboratebackend.model.RegisterUser;

@Repository
public class RegisterDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void insert(RegisterUser user)
	{
		sessionFactory.openSession().save(user);
	}
	
	@Transactional
	public List<RegisterUser> getAllUser()
	{
		Criteria cr=sessionFactory.openSession().createCriteria(RegisterUser.class);
		
		return cr.list();
	}
	
	@Transactional
	public RegisterUser loginCheck(RegisterUser ru)
	{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from RegisterUser rr where rr.name='"+ru.getName()+"' and rr.password='"+ru.getPassword()+"'");
		List <RegisterUser> list=q.list();
		RegisterUser r=list.get(0);
		System.out.println("Inside dao  "+r.getName());
		return r;
 		
	}

}
