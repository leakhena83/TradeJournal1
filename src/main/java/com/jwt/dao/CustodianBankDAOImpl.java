package com.jwt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.CustodianBank;


@Repository
public class CustodianBankDAOImpl implements CustodianBankDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<CustodianBank> getCustodianBanks(Integer start , Integer end) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM CustodianBank c ORDER BY c.cbd_id DESC");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<CustodianBank> custodianBankList = query.list();
		return custodianBankList; 
	}
	
	@SuppressWarnings("unchecked")
	public List<CustodianBank> getCustodianBanksAcd(Integer start , Integer end) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM CustodianBank c ORDER BY c.cbd_id");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<CustodianBank> custodianBankList = query.list();
		return custodianBankList; 
	}
	

}