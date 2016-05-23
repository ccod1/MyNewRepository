package com.musichub.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;

@Service
public class DataService {

	@Autowired
	private DataB db;
	
	
	public void insert(UserDetails ud)
	{
		
		db.insert(ud);
		
		
	}
	
	
	public Product_Info getProductById (int id) {
       
		Product_Info pi=(Product_Info)db.getProductById(id);
        return pi;
    }
	
	
	public void updateProduct(Product_Info pi)
	{
		db.updateProduct(pi);
	}
	
	public void deleteProduct(Product_Info pi)
	{
		db.deleteProduct(pi);
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
