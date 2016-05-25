package com.project2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.project2.model.User;
import com.project2.model.UserDetail;
import com.project2.model.UserRole;
@Repository
@Transactional
public class UserDetailDaoImpl implements UserDetailDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	public void addUser(UserDetail usersDetail) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 User newUser=new User();
		 newUser.setUsername(usersDetail.getUsername());
		 newUser.setPassword(usersDetail.getPassword());
	        newUser.setEnabled(true);
	     //   newUser.setUserId(usersDetail.getUserId());
	      newUser.setUsersId(usersDetail.getUserId());  
	      newUser.setUserId(usersDetail.getUserId());
	      session.saveOrUpdate(newUser);
	      session.saveOrUpdate(usersDetail);
	     UserRole newUserRole =new UserRole();
	     newUserRole.setUsername(usersDetail.getUsername());
	     newUserRole.setRole("ROLE_USER");
	     session.saveOrUpdate(newUserRole);
	}

	public UserDetail getUserById(int userId) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
	        return (UserDetail) session.get(UserDetail.class, userId);
	
	}

	public List<UserDetail> getAllUsers() {
		 Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from UserDetail");
	        List<UserDetail> usersDetail = query.list();

	        return usersDetail;
	}

	public UserDetail getUserByUsername(String username) {
		 Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from UserDetail where username = ?");
	        query.setString(0, username);

	        return (UserDetail) query.uniqueResult();
	}

}
