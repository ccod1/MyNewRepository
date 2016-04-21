package com.finalproject.daopack;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.finalproject.mod.Product_Info;


import com.finalproject.mod.*;


@Repository
//@Transactional
public class DataB{
	
private List<Product_Info> pr=new ArrayList<Product_Info>();

@Autowired
private SessionFactory sessionFactory;

	

	public void insertUserData(User_Info ui)
	{
		Session ses= sessionFactory.openSession();
		ses.save(ui);
		ses.flush();
		
	
	}

	public List<Product_Info> getData()
	{
		Session ses=sessionFactory.getCurrentSession();
		Criteria c=ses.createCriteria(Product_Info.class);
		
		List<Product_Info> pr= c.list();
		
		return pr;
	}
	
	public void updateUserData(User_Info ui)
	{
		Session ses=sessionFactory.getCurrentSession();
		ses.update(ui);
		ses.flush();
		
	}
	
	public void deleteUserData(User_Info ui)
	{
		Session ses=sessionFactory.getCurrentSession();
		ses.delete(ui);
		ses.flush();
	}
		

}
