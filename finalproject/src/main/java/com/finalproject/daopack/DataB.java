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

	

	public void insertData()
	{
		Session ses= sessionFactory.openSession();
		
		Product_Info i1=new Product_Info();
		i1.setName("A");
		i1.setProduct_id("pro111");
		i1.setProduct_price("1000");
		i1.setDescription("Songs");
		ses.save(i1);
		ses.flush();
		ses.close();
	
	}

	public List<Product_Info> getData()
	{
		Session ses=sessionFactory.getCurrentSession();
		Criteria c=ses.createCriteria(Product_Info.class);
		
		List<Product_Info> pr= c.list();
		
		return pr;
	}
		

}
