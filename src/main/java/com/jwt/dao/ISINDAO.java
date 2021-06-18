package com.jwt.dao;

import java.util.List;
import com.jwt.model.ISIN;


public interface ISINDAO {

	public List<ISIN> getAllISIN();
	
	public ISIN getOneISIN(String isin);

}
