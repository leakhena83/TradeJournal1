package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserDAO;
import com.jwt.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User getUser(String user_name) {
		return userDAO.getUser(user_name);
	}
	
	public User getUser(int user_id) {
		return userDAO.getUser(user_id);
	}
	
	public User getPassword(String password) {
		return userDAO.getPassword(password);
	}
	

}
