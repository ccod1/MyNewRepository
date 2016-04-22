package com.musichub.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musichub.model.UserDetails;

@Service
@Transactional
public class DataService {

	@Autowired
	private DataB db;
	public void insert(UserDetails ud)
	{
		db.insert(ud);
	}
}
