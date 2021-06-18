package com.jwt.service;

import java.util.List;
import com.jwt.model.RestrictionControl;

public interface RestrictionControlService {
	
	public void addRestrictionControl(RestrictionControl restrictioncontrol);

	public List<RestrictionControl> getAllRestrictionControls();
	
	// get oderder entry based on pagination
	public List<RestrictionControl> getRegistrionControls(Integer start, Integer end);

	public void deleteRestrictionControl(Integer restrictioncontrolId);

	public RestrictionControl getRestrictionControl(int restrictionControlId);

	public RestrictionControl updateRestrictionControl(RestrictionControl restrictioncontrol);
}
