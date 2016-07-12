package com.niit.colloborate.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.colloborate.model.Customer;
import com.niit.colloborate.service.ChatMessageService;
import com.niit.colloborate.service.CustomerService;
import com.niit.colloborate.service.MailConfirmationService;


@Controller
public class HomeController {

	@Autowired 
	private ChatMessageService chatseervice;
	
	String name;
	@Autowired
	CustomerService custs;
	
	@Autowired
	MailConfirmationService mailConfirm;
	
	@RequestMapping("/")
	public String goLogin()
	{
		return "login";
	}

	@RequestMapping("/login")
	public String goLogin1()
	{
		return "login";
	}


	@RequestMapping("/signup")
	public String openRegister()
	{
		return "signup";
	}
	
	@ModelAttribute("cust")
	public Customer returnObject()
	{
		return new Customer();
	}
	
	@RequestMapping("/signsuccess")
	public ModelAndView insertCustome(@ModelAttribute("cust") Customer cust)
	{
		cust.setRole_id(2);
		cust.setEnabled(true);
		System.out.println(cust.getEmail());
		custs.insertUser(cust);
		mailConfirm.sendMail(cust.getUsername(), cust.getPassword(),cust.getEmail());
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("msg","Please Check your mail to view the login credentials");
		return mv;
	}
	
	@RequestMapping("/logincheck")
	public ModelAndView login(@RequestParam (value="error", required = false) String error,Model model,Authentication auth,HttpServletRequest request) 
	{
		 String go=null;
		name=request.getParameter("username");
		 String pass=request.getParameter("password");
		 if(custs.login(name, pass))
		 {
			 go="home";
		 }
		 else
		 {
			 model.addAttribute("error", "Invalid username and password!");
			 go="login";
		 }
		 	HttpSession hs=request.getSession();
		 	hs.setAttribute("nn", name);
	       ModelAndView mv=new ModelAndView(go);
	       mv.addObject("name",name);
	       return mv;
	   }

	@RequestMapping("/chat")
	public String goToChat(HttpServletRequest request,Model model)
	{
		//System.out.println(chatseervice);
		String name=request.getParameter("user");
		model.addAttribute("name",name);
		return "chat";
	}
	
}
