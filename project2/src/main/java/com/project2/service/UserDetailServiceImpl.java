package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.furniturestore.dao.UsersDetailDao;
import com.project2.dao.UserDetailDao;
import com.project2.model.UserDetail;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	 @Autowired
	    private UserDetailDao usersDetailDao;

	public void addUser(UserDetail usersDetail) {
		// TODO Auto-generated method stub
		usersDetailDao.addUser(usersDetail);
	}

	public UserDetail getUserById(int userId) {
		// TODO Auto-generated method stub
		 return usersDetailDao.getUserById(userId);
	}

	public List<UserDetail> getAllUsers() {
		// TODO Auto-generated method stub
		 return usersDetailDao.getAllUsers();
	}

	public UserDetail getUserByUsername(String username) {
		// TODO Auto-generated method stub
		 return usersDetailDao.getUserByUsername(username);
	}

}
