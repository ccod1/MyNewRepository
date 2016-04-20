package com.finalproject.cont;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.daopack.DaoService;
import com.finalproject.mod.Product_Info;
import com.google.gson.Gson;






@Controller

public class HomeController
{
	@Autowired
	DaoService s;
	
	
	@RequestMapping("/")
	public String gotoindex()
	{
		return "index";
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
	
	@RequestMapping("/addtocart")
	public String gotoaddtocart(HttpServletRequest re)
	{
	/*	Data d= new Data();
		List <Product_Info> inf=d.getInfo();
		
		ModelAndView mv=new ModelAndView("addtocart");
		
		
		String p_id=re.getParameter("pid");
		
		
		for(Product_Info pf:inf)
		{
			if(p_id.equals(pf.getProduct_id()))
			{
				re.setAttribute("inf", pf);
			}
		}*/
		

		
		return "addtocart";
	}
	
	
	@RequestMapping("/header")
	public ModelAndView openHeader()
	{
		ModelAndView mv=new ModelAndView("header");
		return mv;
	}
	
	
	@RequestMapping("/home")
	public String gotoHome()
	{
		return "home";
	}


	@RequestMapping("/home1")
	public @ResponseBody String fetchInfo()
	{
		
		
	
		
		//s.insertData();
		
		
		String json="";
		List <Product_Info> pr=(List <Product_Info>)s.getData();
		
		for(Product_Info p:pr)
		System.out.println(p);
		
		Gson gs=new Gson();
		json=gs.toJson(pr);
		System.out.println(json);
		
		
		//JsonParser jsp=new JsonParser();
		
		//ModelAndView mv=new ModelAndView("home");
		
		//mv.addObject("listData",json);
		
		
		return json;
		
	
	}

}
