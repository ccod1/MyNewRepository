package com.springmusichub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

 
	@RequestMapping("/")
	public ModelAndView showMessage()
			//@RequestParam(value = "name", required = false, defaultValue = "World") String name) 
	{
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Success !!!");
		//mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView openSignin()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView openSignup()
	{
		ModelAndView mv=new ModelAndView("signup");
		return mv;
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView openaboutus()
	{
		ModelAndView mv=new ModelAndView("aboutus");
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView openhome()
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("/allcat")
	public ModelAndView openAllcat()
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
}