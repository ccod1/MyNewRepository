package com.musichub.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.musichub.model.Product_Info;

public class UpdateDb
{
	public void edit(Product_Info pi,SessionFactory sf)
	{
		System.out.println("Im inside UpdateDb class");
		Session ss=sf.openSession();
		//ss.update(pi);
		SQLQuery sql=ss.createSQLQuery("update Product_Info set code='"+pi.getCode()+"',desc='"+pi.getDesc()+"',manufact='"+pi.getManufact()+"',name='"+pi.getName()+"',price='"+pi.getPrice()+"',type='"+pi.getType()+"' where code='"+pi.getCode()+"'");
		int val =sql.executeUpdate();
		System.out.println("Updated value  "+val);
		System.out.println(pi.getPrice());
		ss.flush();
	}

}
