package com.musichub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;


@Repository
public class DataB {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(UserDetails us)
	{
		Session s=sessionFactory.getCurrentSession();	
		s.save(us);
		s.flush();
		//SQLQuery sqlq=s.createSQLQuery("insert into user_authentication values (2,'ROLE_USER','"+us.getUsername()+"')");
		//sqlq.setParameter("id", us.getRoleid());
		//sqlq.setParameter("role", us.getSecretValue());
		//sqlq.setParameter("username", us.getUsername());
		//sqlq.executeUpdate();
		s.flush();
		
	}
	
	public void insertProduct(Product_Info pi)
	{
		try{
		System.out.println("inside insertProduct.......");
		Session s=sessionFactory.getCurrentSession();	
		s.save(pi);
		s.flush();
		
		System.out.println("after insertproduct.......");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product_Info po)
	{
		try{
		System.out.println("inside insertProduct.......");
		Session s=sessionFactory.getCurrentSession();	
		
		Criteria cs=s.createCriteria(Product_Info.class);
		cs.add(Restrictions.eq("code", po.getName()));
		//List <Product_Info>pr=cs.list();
		//int code=0;
		//for(Product_Info pi:pr)
		//{
		//	System.out.println(pi.getName());
			System.out.println(po.getName());
		/*	if(pi.getName().equals(po.getName()))
			{
				SQLQuery sqlq=s.createSQLQuery("update product_info set desc='"+pi.getDesc()+"',manufact='"+pi.getManufact()+"',name='"+pi.getName()+"' where code=?");
				sqlq.setInteger(1, pi.getCode());
				sqlq.executeUpdate();
				System.out.println("inside update product done");
			}
		}
		 
		//SQLQuery sqlq=s.createSQLQuery("");
		
		*/
		
		s.update(po);
		s.flush();
		
		//System.out.println("after insertproduct.......");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<Product_Info> getProductInfo(int code)
	{
		Session s=sessionFactory.getCurrentSession();
		Criteria cr=s.createCriteria(Product_Info.class);
		cr.add(Restrictions.eq("code", code));
		List<Product_Info> pr=cr.list();
		return pr;
	}
	
	public List<Product_Info> getInfo(String type)
	{
		List<Product_Info> pi=new ArrayList<Product_Info>();
		Session s=sessionFactory.getCurrentSession();
		Criteria cr=s.createCriteria(Product_Info.class);
		if(!type.equals("allcat"))
		{
			cr.add(Restrictions.eq("type", type));
			pi=cr.list();
		}
		else
		{
			pi=cr.list();
		}
		
		return pi;
	}
	
	public List<Product_Info> getInfo()
	{
		List<Product_Info> pi=new ArrayList<Product_Info>();
		Session s=sessionFactory.getCurrentSession();
		Criteria cr=s.createCriteria(Product_Info.class);
		
			pi=cr.list();
		
		
		return pi;
	}
}
