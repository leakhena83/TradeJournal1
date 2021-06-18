package com.jwt.dao;

import java.util.List;

import com.jwt.model.CustodianBank;

public interface CustodianBankDAO {

	// get custodianBank record based on pagination with Decendant
	public List<CustodianBank> getCustodianBanks(Integer strart , Integer End);
	
	//get custodianBank record based on pagination with Ascendant 
	public List<CustodianBank> getCustodianBanksAcd(Integer strart , Integer End);

}
