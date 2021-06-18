package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.CorporateActionRegisterDAO;
import com.jwt.model.CorporateActionRegister;

@Service
@Transactional
public class CorporateActionRegisterServiceImpl implements CorporateActionRegisterService {

	@Autowired
	private CorporateActionRegisterDAO corporateActionRegisterDAO;

	@Override
	@Transactional
	public List<CorporateActionRegister> getCorporateActionReigsters(Integer start, Integer end){
		return corporateActionRegisterDAO.getCorporateActionRegisters(start, end) ;
	}
	
	//get onlly one recordset 
	public CorporateActionRegister getCorporateActionReigster(Integer corporateActionRegisterId) {
		return corporateActionRegisterDAO.getCorporateActionRegister(corporateActionRegisterId);
	}
	
	//delete recordset corporate action register
	@Override
	@Transactional
	public void deleteCorporateActionRegister(Integer corporateActionRegisterId) {
		corporateActionRegisterDAO.deleteCorporateActionRegister(corporateActionRegisterId);
	}
}
