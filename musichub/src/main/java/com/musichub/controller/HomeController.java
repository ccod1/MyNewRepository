package com.musichub.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.musichub.dao.DataService;
import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;
import com.musichub.validator.ProductValidation;

@Controller
public class HomeController {

	@Autowired
	private DataService ds;
	@RequestMapping("/")
	public String go(HttpServletRequest re)
	{
		//System.out.println(re.getContextPath());
		return "index";
	}
	
	@RequestMapping("/index")
	public String gotohome()
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
		user.setSecretValue("ROLE_USER");
		user.setRoleid(2);
		ds.insert(user);
		System.out.println(user.getUsername());
		return "signsuccess";
	}
	
	@ModelAttribute("product")
	public Product_Info createProdcut()
	{
		System.out.println("inside createProduct");
		return new Product_Info();
	}
	
	
	@RequestMapping("/toflow")
	public String toFlow()
	{
		return "redirect:/checkout?shop="+"shop";
	}
	
	@Autowired
	private ProductValidation prodvalidator;
	@RequestMapping(value="/addprosuccess",params="add",method=RequestMethod.POST)
	public String gotosuccsess(@ModelAttribute("product") @Valid Product_Info product,BindingResult result,HttpServletRequest re)
	{
		MultipartFile file=product.getImgFile();
		System.out.println(file.getOriginalFilename());
		String fileName="";
		prodvalidator.validate(product, result);
		if(result.hasErrors())
		{		
			return "productform";
		}
		else
		{
			if(!file.isEmpty())
			{
				try
				{
					
					fileName=file.getOriginalFilename();
					byte[] bytes=file.getBytes();
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File("E:/musichub/src/main/webapp/resources/image/"+fileName)));
					bos.write(bytes);
					bos.close();
					ds.insertProduct(product);
					System.out.println("After insertion.......");
					
					
			
				}
				catch(Exception e)
				{  
						System.out.println(e);
						return "You failed to upload the file ";
				}
				
			}
			return "addprosuccess";
		}
	}
	

	@RequestMapping(value="/addprosuccess",params="edit",method=RequestMethod.POST)
	public String doEdit(@ModelAttribute("product") Product_Info product)
	{
		ds.updateProduct(product);
		System.out.println(product.getName());
		return "addprosuccess";
	}
	String type="";

	@RequestMapping("/home")
	public String gotoHome(HttpServletRequest re)
	{
		type=re.getParameter("im1");
		System.out.println(type);
		return "home";
	}


	@RequestMapping("/productinfo")
	public ModelAndView showProductInfo(HttpServletRequest re)
	{
		int code=Integer.parseInt(re.getParameter("pid"));
		
		ModelAndView mv=new ModelAndView("productinfo");
		
		List <Product_Info> pr = ds.getProductInfo(code);
		System.out.println(re.getContextPath());
		
		String src="E:/musichub/src/main/webapp/resources/image/";
		
		for(Product_Info p:pr)
		{
			
			src=p.getName();
			System.out.println(src);
			String img="/resources/image/"+src+"."+"jpg";
			System.out.println(img);
			p.setImg(img);
			mv.addObject("proinf", p);
		}
		
		return mv;
	}
	
	@RequestMapping("/home1")
	public @ResponseBody String fetchInfo(HttpServletRequest re)
	{		
		
		System.out.println("inside home1  "+type);
		String json="";
		List <Product_Info> pr=(List <Product_Info>)ds.getInfo(type);		
		for(Product_Info p:pr)
		System.out.println(p);		
		Gson gs=new Gson();
		json=gs.toJson(pr);
		System.out.println(json);		
		return json;
		
	
	}
	
	
	@RequestMapping("/admin")
	public String gotoProduct()
	{
		return "admin";
	}
	
	
	
	
	
/*	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(value="error",required=false) String error,
							  @RequestParam(value="logout",required=false) String logout)
	{
		ModelAndView model=new ModelAndView();
		if(error!=null)
		{
			model.addObject("error","Invalid Username and Password !");
		}
		
		if(logout!=null)
		{
			model.addObject("msg","You have been logged out successfully.");
		}
		
		model.setViewName("login");
		return model;
		
	} 

	*/
	
	@RequestMapping("/aproductinfo")
	public String gotoAdmin()
	{
		return "aproductinfo";
	}
	
	@RequestMapping("/aproductinfo1")
	public @ResponseBody String gotoAdmin1()
	{
		//System.out.println("inside home1  "+type);
		String json="";
		List <Product_Info> pr=(List <Product_Info>)ds.getInfo();		
		for(Product_Info p:pr)
		{
			System.out.println(p.getName());
		}
		Gson gs=new Gson();
		json=gs.toJson(pr);
		System.out.println("json  "+json);		
		return json;
	}
	
	@RequestMapping("/proedit")
	public  String goToEdit(HttpServletRequest re)
	{
		int code=Integer.parseInt(re.getParameter("code"));
		ModelAndView mv=new ModelAndView();
		return "eproductform";
		
	}
	
	
	@RequestMapping("/login")
	   public String login(@RequestParam (value="error", required = false) String error,
	                       @RequestParam (value="logout", required = false) String logout, Model model
	                       ) {

	       if(error != null) {
	           model.addAttribute("error", "Invalid username and password!");
	       }

	       if(logout!= null) {
	           model.addAttribute("msg", "You have been logged out successfully.");
	       }

	       return "login";
	   }
	   
	
}
