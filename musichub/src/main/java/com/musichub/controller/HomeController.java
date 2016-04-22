package com.musichub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.musichub.dao.DataService;
import com.musichub.model.UserDetails;

@Controller
public class HomeController {

	@Autowired
	private DataService ds;
	@RequestMapping("/")
	public String go()
	{
		return "index";
	}
	
	
	public HomeController(DataService ds) {
	
		this.ds = ds;
	}
public HomeController() {
	// TODO Auto-generated constructor stub
}

	@ModelAttribute("user")
	public UserDetails create1()
	{
		System.out.println("inside modelattribute");
		return new UserDetails();
	}

	@RequestMapping("/signup")
	public String toSignUp()
	{
		return "signup";
		
	}
	@RequestMapping(value="/signsuccess",params="add",method=RequestMethod.POST)
	public String doRegister1(@ModelAttribute("userdetails") UserDetails user)
	{
		ds.insert(user);
		System.out.println(user.getName());
		return "signsuccess";
	}
	
	
}
