package com.jwt.service;

import java.util.List;

import com.jwt.model.CustodianBank;


public interface CustodianBankService {
	
	// get all custodian bank data based on pagination with Decendant
	public List<CustodianBank> getCustodianBanks(Integer start, Integer end);
	
	// get all custodian bank data based on pagination with Ascendant
	public List<CustodianBank> getCustodianBanksAcd(Integer start, Integer end);

}
