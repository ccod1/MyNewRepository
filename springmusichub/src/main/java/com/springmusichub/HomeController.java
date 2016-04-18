package com.springmusichub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.model.Product_Info;



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
	
	
	@RequestMapping("/header")
	public ModelAndView openHeader()
	{
		ModelAndView mv=new ModelAndView("header");
		return mv;
	}
	
	@RequestMapping("/footer")
	public ModelAndView openFooter()
	{
		ModelAndView mv=new ModelAndView("footer");
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
	
	@Autowired
	private Data d;
	
	@RequestMapping("/addtocart")
	public String gotoaddtocart()
	{
		List <Product_Info> pr=d.getInfo();
		
		ModelAndView mv=new ModelAndView("addtocart");
		mv.addObject("listData",pr);
		
		return "addtocart";
	}
	
	//ObjectMapper jsonMapper=new ObjectMapper();
	
	/*@RequestMapping(value="/home",method=RequestMethod.GET)
	public ResponseEntity<List <Product_Info>> listProducts()
	{
		List<Product_Info> pr=d.getInfo();
		return new ResponseEntity<List<Product_Info>>(pr,HttpStatus.OK);
	}*/
	
	@RequestMapping("/home")
	public String gotoHome()
	{
		return "home";
	}
	
	
	
	
	@RequestMapping("/home1")
	public String fetchInfo()
	{
		List <Product_Info> pr=(List <Product_Info>)d.getInfo();
		for(Product_Info p:pr)
		System.out.println(p);
		
		Gson gs=new Gson();
		String json=gs.toJson(pr);
		System.out.println(json);
		//JsonParser jsp=new JsonParser();
		
		//ModelAndView mv=new ModelAndView("home");
		
		//mv.addObject("listData",json);
		
		return json;
		
		
		
		
		
	}
	
	/*public @ResponseBody String openhome(Model model)
	{
		//ModelAndView mv=new ModelAndView("home");
		
		
		List<Product_Info> pr=d.getInfo();
		
		model.addAttribute("listData", pr);
		
		
		
		//mv.addObject("listData", pr);
		
		return "home";
	}*/
	
	@RequestMapping("/allcat")
	public ModelAndView openAllcat()
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	

	
	
}