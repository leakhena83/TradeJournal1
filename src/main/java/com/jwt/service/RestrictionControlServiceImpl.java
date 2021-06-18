package com.jwt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.RestrictionContorlDAO;
import com.jwt.model.RestrictionControl;

@Service
@Transactional
public class RestrictionControlServiceImpl implements RestrictionControlService {

	@Autowired
	private RestrictionContorlDAO restrictioncontrolDAO;
	
	//Create OrderEntry object 
	public void setRestrictionControlDAO(RestrictionContorlDAO restrictioncontrolDAO) {
		this.restrictioncontrolDAO = restrictioncontrolDAO;
	}

	@Override
	@Transactional
	public void addRestrictionControl(RestrictionControl restrictioncontrol) {
		restrictioncontrolDAO.addRestrictionControl(restrictioncontrol);
	}

	@Override
	@Transactional
	public List<RestrictionControl> getAllRestrictionControls() {
		return restrictioncontrolDAO.getAllRestrictionControls();
	}
	
	//for pagination limit record set 
	@Override
	public List<RestrictionControl> getRegistrionControls(Integer start, Integer end) {
			return restrictioncontrolDAO.getRestrictionControls(start, end);
		}
	
	//get onlly one recordset 
	public RestrictionControl getRestrictionControl(int restrictioncontrolId) {
			return restrictioncontrolDAO.getRestrictionControl(restrictioncontrolId);
	}

	@Override
	@Transactional
	public void deleteRestrictionControl(Integer restrictioncontrolId) {
		restrictioncontrolDAO.deleteRestrictionControl(restrictioncontrolId);
	}

	public RestrictionControl updateRestrictionControl(RestrictionControl restrictioncontrol) {
		// TODO Auto-generated method stub
		return restrictioncontrolDAO.updateRestrictionControl(restrictioncontrol);
	}
	
}
