package com.jwt.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jwt.model.RestrictionControl;

import org.hibernate.Query;

@Repository
public class RestrictionControlDAOImpl implements RestrictionContorlDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRestrictionControl(RestrictionControl restrictioncontrol ) {
		sessionFactory.getCurrentSession().saveOrUpdate(restrictioncontrol);

	}

	@SuppressWarnings("unchecked")
	public List<RestrictionControl> getAllRestrictionControls() {
		String restrictionControlList = "FROM RestrictionControl r ORDER BY r.rcs_id";
		return sessionFactory.getCurrentSession().createQuery(restrictionControlList)
				.list();
	}
	
	//get limit record for pagination 
	@SuppressWarnings("unchecked")
	public List<RestrictionControl> getRestrictionControls(Integer start, Integer end) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM RestrictionControl r ORDER BY r.rcs_id DESC");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<RestrictionControl> restrictioncontrolList = query.list();
		return restrictioncontrolList; 
	}

	@Override
	public void deleteRestrictionControl(int restrictioncontrolId) {
		RestrictionControl restrictionControl = (RestrictionControl) sessionFactory.getCurrentSession().load(
				RestrictionControl.class, restrictioncontrolId);
		if (null != restrictionControl) {
			this.sessionFactory.getCurrentSession().delete(restrictionControl);
		}

	}

	public RestrictionControl getRestrictionControl(int restrictionControlId) {
		return (RestrictionControl) sessionFactory.getCurrentSession().get(
				RestrictionControl.class, restrictionControlId);
	}

	@Override
	public RestrictionControl updateRestrictionControl(RestrictionControl restrictionControl) {
		sessionFactory.getCurrentSession().update(restrictionControl);
		return restrictionControl;
	}

}