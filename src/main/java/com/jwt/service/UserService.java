package com.jwt.service;

import com.jwt.model.User;

public interface UserService {

	public User getUser(String user_name);
	public User getPassword(String password);
	public User getUser(int user_id);
}
