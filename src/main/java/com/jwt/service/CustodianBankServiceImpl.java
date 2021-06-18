package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.CustodianBankDAO;
import com.jwt.model.CustodianBank;


@Service
@Transactional
public class CustodianBankServiceImpl implements CustodianBankService {

	@Autowired
	private CustodianBankDAO custodianBankDAO;

	@Override
	@Transactional
	public List<CustodianBank> getCustodianBanks(Integer start, Integer end){
		return custodianBankDAO.getCustodianBanks(start, end);
	}
	
	@Override
	@Transactional
	public List<CustodianBank> getCustodianBanksAcd(Integer start, Integer end){
		return custodianBankDAO.getCustodianBanksAcd(start, end);
	}
	
}
