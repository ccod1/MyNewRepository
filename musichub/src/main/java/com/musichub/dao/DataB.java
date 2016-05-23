package com.musichub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;


@Repository
@Transactional
public class DataB {

	@Autowired
	private SessionFactory sessionFactory;

	public void insert(UserDetails us)
	{
		Session s=sessionFactory.openSession();	
		s.save(us);
		//s.flush();
		
		
	}
	
	
	public void insertProduct(Product_Info pi)
	{
		try{
		System.out.println("inside insertProduct.......");
		Session s=sessionFactory.openSession();	
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
		
	
		UpdateDb ud=new UpdateDb();
		ud.edit(po, sessionFactory);
		
		/*Session s=sessionFactory.openSession();	
		s.saveOrUpdate(po); 
		s.flush();
	
		//s.refresh(po);*/
		
		
	}
	
	public void deleteProduct(Product_Info pi)
	{
		Session s=sessionFactory.openSession();
		s.delete(pi);
		s.flush();
		
		
	}
	
	

	public List<Product_Info> getProductInfo(int code)
	{
		Session s=sessionFactory.openSession();
		Criteria cr=s.createCriteria(Product_Info.class);
		cr.add(Restrictions.eq("code", code));
		List<Product_Info> pr=cr.list();
		return pr;
	}
	
	
	public List<Product_Info> getInfo(String type)
	{
		List<Product_Info> pi=new ArrayList<Product_Info>();
		Session s=sessionFactory.openSession();
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
	

	public Product_Info getProductById (int id) {
        Session session = sessionFactory.openSession();
        Product_Info pi = (Product_Info) session.get(Product_Info.class, id);
        session.flush();
        System.out.println("get by id  "+pi.getCode() );
        return pi;
    }

	

	public List<Product_Info> getInfo()
	{
		List<Product_Info> pi=new ArrayList<Product_Info>();
		Session s=sessionFactory.openSession();
		Criteria cr=s.createCriteria(Product_Info.class);
		pi=cr.list();
		return pi;
	}
}
