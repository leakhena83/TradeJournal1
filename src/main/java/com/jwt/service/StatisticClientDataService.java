package com.jwt.service;

import java.util.List;
import com.jwt.model.StatisticClientData;

public interface StatisticClientDataService {
	
	public void addClinetData(StatisticClientData clientData);

	public List<StatisticClientData> getAllClientDatas();
	
	// get statistic client data based on pagination
	public List<StatisticClientData> getClientDatas(int start, int end, String user_role, int user_id);

	public void deleteClientData(int clientId);

	public StatisticClientData getClientData(int clientId);

	public StatisticClientData updateClientData(StatisticClientData clientData);
}
