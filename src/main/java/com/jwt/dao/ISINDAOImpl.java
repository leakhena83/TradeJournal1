package com.jwt.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jwt.model.ISIN;

@Repository
public class ISINDAOImpl implements ISINDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<ISIN> getAllISIN() {

		return sessionFactory.getCurrentSession().createQuery("from ISIN")
				.list();
	}
	
	public ISIN getOneISIN(String isin) {
		return (ISIN) sessionFactory.getCurrentSession().get(
				ISIN.class, isin);
	}

}