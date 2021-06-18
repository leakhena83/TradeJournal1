package com.jwt.dao;

import java.util.List;
import com.jwt.model.CorporateActionRegister;

public interface CorporateActionRegisterDAO {

	// get corporate action register based on pagination with Decendant
	public List<CorporateActionRegister> getCorporateActionRegisters(Integer strart , Integer End);
	
	//get only one record corporate register 
	public CorporateActionRegister getCorporateActionRegister(int corporateActionRegisterId);
	
	//delete corporate action register record
	public void deleteCorporateActionRegister(int corporateActionRegisterId);
	
}
