package com.niit.colloborate.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.colloborate.model.Blog;
import com.niit.colloborate.model.BlogContent;
import com.niit.colloborate.model.Customer;
import com.niit.colloborate.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogservice;
	
	@ModelAttribute("blog_content")
	public BlogContent returnBlogContentObject()
	{
		return new BlogContent();
	}
	
	@RequestMapping("/createblog")
	public String goToCreateBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("user");
		model.addAttribute("name",name);
		return "createblog";
	}
	
	
	@ModelAttribute("nblg")
	public Blog returnObject()
	{
		return new Blog();
	}
	
	
	@RequestMapping("/create")
	public String createBlog(@ModelAttribute("nblg") Blog blog,Model model)throws IOException
	{
		String name=blog.getCust_name();
		
		//char buff[]=new char[];
		
		String content=null;
		
		
		
		String url=blog.getBlog_name()+".jsp";
		url="D:/workspace1/colloborate/src/main/webapp/WEB-INF/view/"+url;
		System.out.println(url);
		BufferedReader fr=new BufferedReader(new FileReader("D:/workspace1/colloborate/src/main/webapp/WEB-INF/view/writeblog.jsp"));
		BufferedWriter fw=new BufferedWriter(new FileWriter(url));
		while((content=fr.readLine())!=null)
		{	
			fw.write(content);
			fw.newLine();
		}
		
		fr.close();
		fw.close();
		blogservice.createNewBlog(blog);
		
		ModelAndView mv=new ModelAndView();
		model.addAttribute("name",name);
		model.addAttribute("addmess","Successfully blog got created");
		return "createblog";
	}
	
	@RequestMapping("/openblog")
	public String openNewBlog(HttpServletRequest request)
	{
		String bl=request.getParameter("blname");
		return bl;
	}
	
	@RequestMapping("/blog")
	public String goToBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("user");
		model.addAttribute("name",name);
		List<Blog> blogList= blogservice.getBlogList(name);
		Gson gson=new Gson();
		String jsonstring=gson.toJson(blogList);
		model.addAttribute("jstring",jsonstring);
		for(Blog g:blogList)
		System.out.println(g.getBlog_name());
		System.out.println(jsonstring);
		return "blog";
	}
	@RequestMapping("/openbl")
	public String openBlog(HttpServletRequest request,Model model)
	{
		String bln=request.getParameter("bln");
		String name=request.getParameter("user");
		model.addAttribute("blname", bln);
		model.addAttribute("name",name);
		//List<BlogContent> list=blogservice.getBlogContent(bln);
		//Gson gson=new Gson();
		//String jlist=gson.toJson(list);
		//model.addAttribute("list",jlist);
		/*for(BlogContent bl:list)
			System.out.println(bl.getContent());*/
		return bln;
	}
	

	
	@RequestMapping("/insertPost")
	public String insertPost(@ModelAttribute("blog_content") BlogContent content)
	{
		blogservice.insertPost(content);
		System.out.println("Post inserted successfully");
		
		return null;
	}
}
