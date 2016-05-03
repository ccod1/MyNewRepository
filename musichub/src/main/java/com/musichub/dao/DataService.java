package com.musichub.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;

@Service
@Transactional
public class DataService {

	@Autowired
	private DataB db;
	public void insert(UserDetails ud)
	{
		
		db.insert(ud);
		
		
	}
	
	public void updateProduct(Product_Info pi)
	{
		db.updateProduct(pi);
	}
	
	public void insertProduct(Product_Info pi)
	{
		System.out.println("inside dataservice.......");
		db.insertProduct(pi);
	}
	
	public List<Product_Info> getInfo(String type)
	{
		return db.getInfo(type);
	}
	
	public List<Product_Info> getInfo()
	{
		return db.getInfo();
	}
	
	public List<Product_Info> getProductInfo(int code)
	{
		return db.getProductInfo(code);
	}
}
