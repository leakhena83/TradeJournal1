package com.jwt.service;

import java.util.List;
import com.jwt.model.OrderEntry;

public interface OrderEntryService {
	
	public void addOrderEntry(OrderEntry orderentry);

	public List<OrderEntry> getAllOrderEntries();
	
	// get oderder entry based on pagination
	public List<OrderEntry> getOrderEntries(Integer start, Integer end);

	public void deleteOrderEntry(Integer orderentryId);

	public OrderEntry getOrderEntry(int orderentryid);

	public OrderEntry updateOrderEntry(OrderEntry employee);
}
