package com.finalproject.daopack;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.mod.Product_Info;

@Service
@Transactional
public class DaoService {

	@Autowired
    private DataB d;
	
	public void insertData()
	{
	d.insertData();
	}
	
	public List<Product_Info> getData()
	{
		List<Product_Info> pr= d.getData();
		
		return pr;
	}
	

	

}
