package com.jwt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jwt.dao.ISINDAO;
import com.jwt.model.ISIN;

@Service
@Transactional
public class ISINServiceImpl implements ISINService {

	@Autowired
	private ISINDAO isinDAO;

	@Override
	@Transactional
	public List<ISIN> getAllISIN() {
		return isinDAO.getAllISIN();
	}

	@Override
	public ISIN getOneISIN(String isin) {
		return isinDAO.getOneISIN(isin);
	}

}
