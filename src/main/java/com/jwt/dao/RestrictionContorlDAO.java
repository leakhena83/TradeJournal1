package com.jwt.dao;

import java.util.List;

import com.jwt.model.RestrictionControl;

public interface RestrictionContorlDAO {

	public void addRestrictionControl(RestrictionControl restrictioncontrol);

	public List<RestrictionControl> getAllRestrictionControls();
	
	// get restriction control  based on pagination
	public List<RestrictionControl> getRestrictionControls (Integer strart , Integer End);

	public void deleteRestrictionControl(int restrictionControlId);

	public RestrictionControl updateRestrictionControl(RestrictionControl restrictionControl);

	public RestrictionControl getRestrictionControl(int restrictionControlId);
}
