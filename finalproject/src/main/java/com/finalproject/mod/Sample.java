package com.finalproject.mod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sample {
@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int val1;

	public int getVal1() {
		return val1;
	}

	public void setVal1(int val1) {
		this.val1 = val1;
	}
	
	
}
