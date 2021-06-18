package com.jwt.dao;

import com.jwt.model.User;

public interface UserDAO {

	public User getUser(String user_name);
	public User getPassword(String password);
	public User getUser(int user_id);
}
