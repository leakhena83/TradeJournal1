package com.jwt.dao;

import java.util.List;
import com.jwt.model.StatisticClientData;

public interface StatisticClientDataDAO {

	public void addStatisticClientData(StatisticClientData clientData);

	public List<StatisticClientData> getAllClientDatas();
	
	// get statistict client data entry based on pagination
	public List<StatisticClientData> getStatisticClientDatas(int start , int end , String user_role, int user_id);

	public void deleteStatisticClientData(int clientId);

	public StatisticClientData updateStatisticClientData(StatisticClientData clientData);

	public StatisticClientData getStatisticClientData(int clientId);
	
	
}
