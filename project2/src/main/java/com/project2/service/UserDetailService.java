package com.project2.service;

import java.util.List;

import com.project2.model.UserDetail;



public interface UserDetailService {
	void addUser (UserDetail usersDetail);

    UserDetail getUserById (int userId);

    List<UserDetail> getAllUsers();

    UserDetail getUserByUsername (String username);
}
