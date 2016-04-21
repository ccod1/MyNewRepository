package com.finalproject.daopack;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.mod.Product_Info;
import com.finalproject.mod.User_Info;

@Service
@Transactional
public class DaoService {

	@Autowired
    private DataB d;
	
	public void insertUserData(User_Info ui)
	{
	d.insertUserData(ui);
	}
	
	public List<Product_Info> getData()
	{
		List<Product_Info> pr= d.getData();
		
		return pr;
	}
	
	public void updateUserData(User_Info ui)
	{
		d.updateUserData(ui);
	}
	
	public void deleteUserData(User_Info ui)
	{
		d.deleteUserData(ui);
	}

}
