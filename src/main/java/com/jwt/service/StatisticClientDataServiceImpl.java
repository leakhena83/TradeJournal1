package com.jwt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.StatisticClientDataDAO;
import com.jwt.model.StatisticClientData;

@Service
@Transactional
public class StatisticClientDataServiceImpl implements StatisticClientDataService {

	@Autowired
	private StatisticClientDataDAO clientDataDAO;
	
	//Create ClientData object 
	public void setClientDataDAO(StatisticClientDataDAO clientDAO) {
		this.clientDataDAO = clientDAO;
	}

	@Override
	@Transactional
	public void addClinetData( StatisticClientData clientData) {
		clientDataDAO.addStatisticClientData(clientData);
	}

	@Override
	@Transactional
	public List<StatisticClientData> getAllClientDatas() {
		return clientDataDAO.getAllClientDatas();
	}
	
	//for pagination limit record set 
	@Override
	public List<StatisticClientData> getClientDatas(int start, int end , String user_role , int user_id) {
			return clientDataDAO.getStatisticClientDatas(start, end , user_role , user_id);
		}
	
	//get onlly one recordset 
	public StatisticClientData getClientData(int clientId) {
			return clientDataDAO.getStatisticClientData(clientId);
	}

	@Override
	@Transactional
	public void deleteClientData(int clientId) {
		clientDataDAO.deleteStatisticClientData(clientId);
	}

	public StatisticClientData updateClientData(StatisticClientData clientData) {
		return clientDataDAO.updateStatisticClientData(clientData) ;
	}
	
	

	

}
