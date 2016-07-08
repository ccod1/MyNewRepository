package com.niit.colloborate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.colloborate.dao.Customerdoa;
import com.niit.colloborate.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	Customerdoa custdao;
	
	public void insertUser(Customer cust)
	{
		custdao.insertUser(cust);
	}
	
	 public boolean login(String user,String pass)
	 {
		 return custdao.login(user, pass);
	 }
	
	    
	
}
