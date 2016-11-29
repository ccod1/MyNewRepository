package com.niit.colloboratebackend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.colloboratebackend.dao.RegisterDao;
import com.niit.colloboratebackend.model.RegisterUser;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterDao regd;

	public void insert(RegisterUser reg)
	{
		regd.insert(reg);
	}
	
	public List<RegisterUser> getAllUser()
	{
		return regd.getAllUser();
	}
	
	public RegisterUser loginCheck(RegisterUser ru)
	{
		return regd.loginCheck(ru);
	}
}
