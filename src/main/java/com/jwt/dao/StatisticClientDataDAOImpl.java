package com.jwt.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.StatisticClientData;

import org.hibernate.Query;

@Repository
public class StatisticClientDataDAOImpl implements StatisticClientDataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStatisticClientData(StatisticClientData clientData) {
		sessionFactory.getCurrentSession().saveOrUpdate(clientData);

	}

	@SuppressWarnings("unchecked")
	public List<StatisticClientData> getAllClientDatas() {
		String orderentyList = "FROM StatisticClientData s ORDER BY s.scd_id";
		return sessionFactory.getCurrentSession().createQuery(orderentyList)
				.list();
	}
	
	//get limit record for pagination 
	@SuppressWarnings("unchecked")
	public List<StatisticClientData> getStatisticClientDatas(int start, int end, String user_role , int user_id) {
		Query query ;
		if (user_role.equals("normal user")) {
			query = sessionFactory.getCurrentSession().createQuery("FROM StatisticClientData s WHERE s.usr_id = :user_id ORDER BY s.scd_id DESC");
			query.setParameter("user_id", user_id);	
		}
		else
			query = sessionFactory.getCurrentSession().createQuery("FROM StatisticClientData s ORDER BY s.scd_id DESC");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<StatisticClientData> clientDataList = query.list();
		return clientDataList; 
	}

	@Override
	public void deleteStatisticClientData(int clientId) {
		StatisticClientData clientData = (StatisticClientData) sessionFactory.getCurrentSession().load(
				StatisticClientData.class, clientId);
		if (null != clientData) {
			this.sessionFactory.getCurrentSession().delete(clientData);
		}

	}

	public StatisticClientData getStatisticClientData(int clientId) {
		return (StatisticClientData) sessionFactory.getCurrentSession().get(
				StatisticClientData.class, clientId);
	}

	@Override
	public StatisticClientData updateStatisticClientData(StatisticClientData clientData) {
		sessionFactory.getCurrentSession().update(clientData);
		return clientData;
	}

}