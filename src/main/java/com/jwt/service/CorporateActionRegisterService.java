package com.jwt.service;

import java.util.List;

import com.jwt.model.CorporateActionRegister;

public interface CorporateActionRegisterService {
	
	// get all corporate register action based on pagination with Decendant
	public List<CorporateActionRegister> getCorporateActionReigsters(Integer start, Integer end);
	
	// get one record corporate register action
	public CorporateActionRegister getCorporateActionReigster(Integer corporateActionRegisterId);
	
	//delete record set corporate register action
	public void deleteCorporateActionRegister(Integer corporateActionRegisterId);
}
