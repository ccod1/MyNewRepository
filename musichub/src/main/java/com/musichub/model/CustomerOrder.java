package com.musichub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerOrder 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cust_id;
	
	
	
	

}
