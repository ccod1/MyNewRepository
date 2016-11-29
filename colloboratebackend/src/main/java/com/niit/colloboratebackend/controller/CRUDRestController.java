package com.niit.colloboratebackend.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.colloboratebackend.model.RegisterUser;
import com.niit.colloboratebackend.service.RegisterService;

@RestController
public class CRUDRestController {
	
	@Autowired
	private RegisterService regs;
	
	
	@RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<RegisterUser> getUser() throws ParseException { 
	 
		
		return regs.getAllUser();
	  }      
	
	@RequestMapping(value="/tasks/insert/{name}/{password}/{email}",method = RequestMethod.POST,headers="Accept=application/json")
	  public List<RegisterUser> addTask(@PathVariable String name,@PathVariable String password,@PathVariable String email) throws ParseException { 
	 
		RegisterUser r=new RegisterUser();
		r.setName(name);
		r.setPassword(password);
		r.setEmail(email);
		regs.insert(r);
		System.out.println("success !!!  "+name);
		return regs.getAllUser();
	  }      
	
	@RequestMapping(value="/login/{username}/{password}",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<RegisterUser> login(@PathVariable String username,@PathVariable String password)
	{
		RegisterUser ru=new RegisterUser();
		ru.setName(username);
		ru.setPassword(password);
		ru=regs.loginCheck(ru);
		if(ru==null)
		{
			System.out.println("invalid credentials");
			return null;                                                                                                                                                                                                                                                                                                                      
		}
		else
		{
			
			return new ResponseEntity<RegisterUser>(ru,HttpStatus.OK);
		}
	}

}
