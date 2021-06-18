package com.jwt.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jwt.model.OrderEntry;
import org.hibernate.Query;

@Repository
public class OrderEntryDAOImpl implements OrderEntryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrderEntry(OrderEntry orderentry) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderentry);

	}

	@SuppressWarnings("unchecked")
	public List<OrderEntry> getAllOrderEntries() {
		String orderentyList = "FROM OrderEntry o ORDER BY o.ode_id";
		return sessionFactory.getCurrentSession().createQuery(orderentyList)
				.list();
	}
	
	//get limit record for pagination 
	@SuppressWarnings("unchecked")
	public List<OrderEntry> getOrderEntries(Integer start, Integer end) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM OrderEntry o ORDER BY o.ode_id DESC");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<OrderEntry> orderentryList = query.list();
		return orderentryList; 
	}

	@Override
	public void deleteOrderEntry(Integer orderentryId) {
		OrderEntry orderentry = (OrderEntry) sessionFactory.getCurrentSession().load(
				OrderEntry.class, orderentryId);
		if (null != orderentry) {
			this.sessionFactory.getCurrentSession().delete(orderentry);
		}

	}

	public OrderEntry getOrderEntry(int orderentryId) {
		return (OrderEntry) sessionFactory.getCurrentSession().get(
				OrderEntry.class, orderentryId);
	}

	@Override
	public OrderEntry updateOrderEntry(OrderEntry orderentry) {
		sessionFactory.getCurrentSession().update(orderentry);
		return orderentry;
	}

}