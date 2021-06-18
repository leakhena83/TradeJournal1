package com.jwt.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.CorporateActionRegister;

@Repository
public class CorporateActionRegisterDAOImpl implements CorporateActionRegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<CorporateActionRegister> getCorporateActionRegisters(Integer start , Integer end) {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM CorporateActionRegister car ORDER BY car.car_id DESC");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<CorporateActionRegister> corporateAactionRegisterList = query.list();
		return corporateAactionRegisterList; 
	}
	
	public CorporateActionRegister getCorporateActionRegister(int corporateActionRegisterId) {
		return (CorporateActionRegister) sessionFactory.getCurrentSession().get(
				CorporateActionRegister.class, corporateActionRegisterId);
	}
	
	@Override
	public void deleteCorporateActionRegister(int corporateActionRegisterId) {
		CorporateActionRegister corporateActionRegister = (CorporateActionRegister) sessionFactory.getCurrentSession().load(
				CorporateActionRegister.class, corporateActionRegisterId);
		if (null != corporateActionRegister) {
			this.sessionFactory.getCurrentSession().delete(corporateActionRegister);
		}

	}
	
}