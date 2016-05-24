package com.musichub.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.musichub.model.CardDetail;
import com.musichub.model.Cart;
import com.musichub.model.UserDetails;
import com.musichub.dao.CardDetailService;
import com.musichub.dao.CartItemService;
import com.musichub.dao.CartService;
import com.furniturestore.model.CartItem;
import com.furniturestore.model.Item;
import com.furniturestore.model.UsersDetail;
import com.google.gson.Gson;
import com.musichub.dao.DataService;
import com.musichub.model.Product_Info;
import com.musichub.model.UserDetails;
import com.musichub.validator.ProductValidation;

@Controller
public class HomeController {

	 @Autowired
	    private CartService cartService;
	    
	   
	    
	    @Autowired
	    private CartItemService cartItemService;

	    @Autowired
	    private CardDetailService cardService;
	@Autowired
	private DataService ds;
	@RequestMapping("/")
	public String go(HttpServletRequest re)
	{
		//System.out.println(re.getContextPath());
		return "index";
	}
	
	/*@RequestMapping("/addtocart")
	public String goToCart()
	{
		System.out.println("Inside add to cart");
		return "addtocart";
	}*/
	
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
		//System.out.println("inside modelattribute");
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
		//System.out.println("inside createProduct");
		return new Product_Info();
	}
	
	
	@RequestMapping("/toflow1")
	public String toFlow()
	{
		return "redirect:/checkout?shop="+"shop"+"&abc=abc";
	}
	
	@RequestMapping("/productform")
	public String goToAddPro()
	{
		return "productform";
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
	
	@RequestMapping(value="/proedit")
	public ModelAndView goToProEdit(HttpServletRequest re)
	{
		Product_Info product=new Product_Info();
		System.out.println("-----"+re.getParameter("code")+"--------");
		product.setCode(Integer.parseInt(re.getParameter("code")));
		product.setName(re.getParameter("name"));
		product.setPrice(Integer.parseInt(re.getParameter("price")));
		product.setManufact(re.getParameter("manufact"));
		product.setDesc(re.getParameter("desc"));
		product.setType(re.getParameter("type"));
		ModelAndView mv=new ModelAndView("eproductform");
		mv.addObject("pi",product);
		return mv;
	}
	
	@RequestMapping(value="/prodelete")
	public String doDelete(HttpServletRequest re)
	{
		int code=Integer.parseInt(re.getParameter("code"));
		System.out.println("Inside do Edit   "+code);
		Product_Info pi=ds.getProductById(code);
		ds.deleteProduct(pi);
		System.out.println("Manufacture----"+pi.getManufact());
		return "redirect:/aproductinfo";
	}

	@RequestMapping(value="/update",params="edit",method=RequestMethod.POST)
	public String doEdit(@ModelAttribute("product") Product_Info product)
	{
	
		System.out.println("Inside do Edit   "+product.getCode());
		//Product_Info pi=ds.getProductById(product.getCode());
		ds.updateProduct(product);
		System.out.println("Manufacture----"+product.getManufact());
		return "redirect:/aproductinfo";
	}
	
	
	String type="";

	@RequestMapping("/home")
	public String gotoHome(HttpServletRequest re)
	{
		type=re.getParameter("im1");
		//System.out.println(type);
		return "home";
	}


	@RequestMapping("/productinfo")
	public ModelAndView showProductInfo(HttpServletRequest re)
	{
		int code=Integer.parseInt(re.getParameter("pid"));
		
		ModelAndView mv=new ModelAndView("productinfo");
		
		List <Product_Info> pr = ds.getProductInfo(code);
	
		
		String src="E:/musichub/src/main/webapp/resources/image/";
		
		for(Product_Info p:pr)
		{
			
			src=p.getName();
			String img="/resources/image/"+src+"."+"jpg";
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
		Gson gs=new Gson();
		json=gs.toJson(pr);		
		return json;
		
	
	}
	
	
	
	
	@RequestMapping("/aproductinfo")
	public String gotoAdmin()
	{
		return "aproductinfo";
	}
	
	@RequestMapping("/aproductinfo1")
	public @ResponseBody String gotoAdmin1()
	{
		String json="";
		List <Product_Info> pr=(List <Product_Info>)ds.getInfo();		
		Gson gs=new Gson();
		json=gs.toJson(pr);	
		return json;
	}
	
	
	
	
	@RequestMapping("/signin")
	public String goToLogin()
	{
		return "signin";
	}
	// @RequestParam (value="logout", required = false) String logout,
	@RequestMapping("/logincheck")
	public String login(@RequestParam (value="error", required = false) String error,Model model,Authentication auth) 
	{
		String role="ROLE_USER";
		if(auth!=null)
		{
			Collection<? extends GrantedAuthority>aa=auth.getAuthorities();
			for(GrantedAuthority ga:aa)
			{
				System.out.println(ga.getAuthority());
				role=ga.getAuthority();
			}
			
		}
		
		String go="admin";
	       if(error != null) {
	    	   go="signin";
	           model.addAttribute("error", "Invalid username and password!");
	           //return go;
	       }

	     /*  if(logout!= null) {
	           model.addAttribute("msg", "You have been logged out successfully.");
	       }*/
	       else
	       {
	    	   if(role.equals("ROLE_USER"))
	    	   {
	    		   go="index";
	    	   }
	       }
	       return go;
	   }
	
	/*@RequestMapping("/logincheck")
	public String printWelcome(ModelMap model,Principal principal)
	{
		System.out.println("In Login Controller");
		String name=principal.getName();
		System.out.println("name:"+name);
		model.addAttribute("username",name);
		model.addAttribute("message","spring security custom example");
		
		return "admin";
	}*/
	   
	
	@RequestMapping(value = "/cardDetail/{cartId}", method = RequestMethod.POST)
    public String CardDetailPost(@PathVariable(value ="cartId") int cartId, @Valid @ModelAttribute("carddetail") CardDetail cardDetail, BindingResult result
    		,@AuthenticationPrincipal User activeUser ,Model model) {
    	List<String> cardTypeList = new ArrayList<String>();
    	cardTypeList.add("Visa-Debit/Credit");
    	cardTypeList.add("Mastercard");
    	List<String> expiryMonthList = new ArrayList<String>();
    	expiryMonthList.add("01");
    	expiryMonthList.add("02");
    	expiryMonthList.add("03");
    	expiryMonthList.add("04");
    	expiryMonthList.add("05");
    	expiryMonthList.add("06");
    	expiryMonthList.add("07");
    	expiryMonthList.add("08");
    	expiryMonthList.add("09");
    	expiryMonthList.add("10");
    	expiryMonthList.add("11");
    	expiryMonthList.add("12");
    	List<String> expiryYearList = new ArrayList<String>();
    	expiryYearList.add("2016");
    	expiryYearList.add("2017");
    	expiryYearList.add("2018");
    	expiryYearList.add("2019");
    	expiryYearList.add("2020");
    	expiryYearList.add("2021");
    	expiryYearList.add("2022");
    	expiryYearList.add("2023");
    	expiryYearList.add("2024");
    	expiryYearList.add("2025");
    	expiryYearList.add("2026");
    	expiryYearList.add("2027");
    	expiryYearList.add("2028");
    	expiryYearList.add("2029");
    	expiryYearList.add("2030");
    	model.addAttribute("cardTypeList",cardTypeList);
    	model.addAttribute("expiryMonthList",expiryMonthList);
    	model.addAttribute("expiryYearList",expiryYearList);
    	//UsersDetail usersDetail = us.getUserByUsername(activeUser.getUsername());
    	Cart cart = cartService.getCartById(cartId);
    	model.addAttribute("cartId", cartId);
    	model.addAttribute("grandTotal", cart.getGrandTotal());

        if (result.hasErrors()) {
            return "cardDetailError";
        }

       
       
        cartItemService.removeAllCartItems(cart);
     //   cardDetail.setUsersDetail(usersDetail);
        cardDetail.setCart(cart);
        cardDetail.setTotalCost(cart.getGrandTotal());
        cardService.addCardDetail(cardDetail);

        return "orderCompleted";

	}
	
	 @RequestMapping(value = "/addItem/{itemId}", method = RequestMethod.PUT)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void addItem (@PathVariable(value ="itemId") int itemId, @AuthenticationPrincipal User activeUser) {

	    	UsersDetail usersDetail = usersDetailService.getUserByUsername(activeUser.getUsername());
	        Cart cart = usersDetail.getCart();
	        Product_Info item = itemService.getItemById(itemId);
	        List<CartItem> cartItems = cart.getCartItems();

	        for (int i=0; i<cartItems.size(); i++) {
	            if(item.getItemId()==cartItems.get(i).getItem().getItemId()){
	                CartItem cartItem = cartItems.get(i);
	                cartItem.setQuantity(cartItem.getQuantity()+1);
	                cartItem.setTotalPrice(item.getItemPrice()*cartItem.getQuantity());
	                cartItemService.addCartItem(cartItem);

	                return;
	            }
	        }

	        CartItem cartItem = new CartItem();
	        cartItem.setItem(item);
	        cartItem.setQuantity(1);
	        cartItem.setTotalPrice(item.getItemPrice()*cartItem.getQuantity());
	        cartItem.setCart(cart);
	        cartItemService.addCartItem(cartItem);
	    }
	    /*
	     * removeItem method is used to remove a item from user cart.
	     */
	    @RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void removeItem (@PathVariable(value = "itemId") int itemId) {
	        CartItem cartItem = cartItemService.getCartItemByItemId(itemId);
	        cartItemService.removeCartItem(cartItem);

	    }
	    /*
	     * clearCartItems method is used to remove all items from user cart.
	     */
	    @RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.DELETE)
	    @ResponseStatus(value = HttpStatus.NO_CONTENT)
	    public void clearCartItems(@PathVariable(value = "cartId") int cartId) {
	        Cart cart = cartService.getCartById(cartId);
	        cartItemService.removeAllCartItems(cart);
	    }
	 
}
