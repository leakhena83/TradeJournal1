package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.OrderEntryDAO;
import com.jwt.model.OrderEntry;

@Service
@Transactional
public class OrderEntryServiceImpl implements OrderEntryService {

	@Autowired
	private OrderEntryDAO orderentryDAO;
	
	//Create OrderEntry object 
	public void setOrderEntryDAO(OrderEntryDAO orderentryDAO) {
		this.orderentryDAO = orderentryDAO;
	}

	@Override
	@Transactional
	public void addOrderEntry(OrderEntry orderentry) {
		orderentryDAO.addOrderEntry(orderentry);
	}

	@Override
	@Transactional
	public List<OrderEntry> getAllOrderEntries() {
		return orderentryDAO.getAllOrderEntries();
	}
	
	//for pagination limit record set 
	@Override
	public List<OrderEntry> getOrderEntries(Integer start, Integer end) {
			return orderentryDAO.getOrderEntries(start,end) ;
		}
	
	//get onlly one recordset 
	public OrderEntry getOrderEntry(int orderentryId) {
			return orderentryDAO.getOrderEntry(orderentryId);
	}


	@Override
	@Transactional
	public void deleteOrderEntry(Integer orderentryId) {
		orderentryDAO.deleteOrderEntry(orderentryId);
	}

	
	public OrderEntry updateOrderEntry(OrderEntry orderentry) {
		// TODO Auto-generated method stub
		return orderentryDAO.updateOrderEntry(orderentry);
	}
	
	

	

}
