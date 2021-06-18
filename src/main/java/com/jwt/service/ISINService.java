package com.jwt.service;

import java.util.List;

import com.jwt.model.ISIN;

public interface ISINService {
	
	// get all ISIN 
	public List<ISIN> getAllISIN();
	
	//get one ISIN 
	public ISIN getOneISIN(String isin);

}
