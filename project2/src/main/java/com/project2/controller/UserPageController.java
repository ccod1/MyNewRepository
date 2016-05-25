package com.project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserPageController {

	@RequestMapping("home")
	public String Home()
	{
		return "home";
		
	}
	@RequestMapping("Blog")
	public String Blog()
	{
		return "Blog";
		
	}
	@RequestMapping("Group")
	public String Group()
	{
		return "Group";
		
	}
	@RequestMapping("Chat")
	public String Chat()
	{
		return "Chat";
	}
}
