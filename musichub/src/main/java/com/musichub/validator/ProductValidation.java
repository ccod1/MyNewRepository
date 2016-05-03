package com.musichub.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.musichub.model.Product_Info;

public class ProductValidation implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Product_Info.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
		Product_Info inf=(Product_Info)arg0;
	}

}
