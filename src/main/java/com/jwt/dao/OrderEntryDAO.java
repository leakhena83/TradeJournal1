package com.jwt.dao;

import java.util.List;

import com.jwt.model.OrderEntry;

public interface OrderEntryDAO {

	public void addOrderEntry(OrderEntry orderentry);

	public List<OrderEntry> getAllOrderEntries();
	
	// get oderder entry based on pagination
	public List<OrderEntry> getOrderEntries(Integer start , Integer end);

	public void deleteOrderEntry(Integer orderentryId);

	public OrderEntry updateOrderEntry(OrderEntry orderentry);

	public OrderEntry getOrderEntry(int orderentryId);
}
