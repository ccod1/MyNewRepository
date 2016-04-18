package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Product_Info;

public class Data {
	
	private List<Product_Info> pr=new ArrayList<Product_Info>();
	
	public List<Product_Info> getInfo()
	{
		Product_Info i1=new Product_Info();
		i1.setName("A");
		i1.setProduct_id("pro111");
		i1.setProduct_price("1000");
		i1.setDescription("Songs");
		
		Product_Info i2=new Product_Info();
		i2.setName("B");
		i2.setProduct_id("pro111");
		i2.setProduct_price("1000");
		i2.setDescription("Songs");
		
		pr.add(i1);
		pr.add(i2);
		
		return pr;
		
	}

}
