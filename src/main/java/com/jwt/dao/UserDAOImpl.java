package com.jwt.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public User getUser(String user_name) {
		
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from User where usr_username=:user_name");
		query.setParameter("user_name", user_name);
		User user = (User) query.uniqueResult();
		
		return user; 

	}
	
	public User getUser(int user_id) {
		
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from User where usr_id=:user_id");
		query.setParameter("user_id", user_id);
		User user = (User) query.uniqueResult();
		
		return user; 

	}
	
	public User getPassword(String password) {
		
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from User where usr_password=:password");
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		
		return user; 

	}

}
