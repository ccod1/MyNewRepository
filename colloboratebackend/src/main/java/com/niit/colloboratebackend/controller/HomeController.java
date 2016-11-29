package com.niit.colloboratebackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String goToIndex()
	{
		return "index";
	}

	
	@RequestMapping("/toflow1")
	public String toFlow()
	{
		return "redirect:/processflow?shop";
	}

}
