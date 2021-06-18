package com.jwt.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.CustodianBank;
import com.jwt.model.OrderEntry;
import com.jwt.service.CustodianBankService;
import com.jwt.service.OrderEntryService;

@Controller
public class DatabaseReconciliationController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CustodianBankService custodianBankService;
	@Autowired
	private OrderEntryService orderEntryService;
	
	@RequestMapping(value = "/databaseReconciliation" , method = RequestMethod.GET)
	@Transactional
	public ModelAndView listRestrictionControl(ModelAndView view,HttpServletRequest request ) throws IOException {
		// index : start of index to fetch from database
		Integer index = Integer.parseInt(request.getParameter("i")) ;
		//end : end of index to fetch from database
		int end = 0 ; 
		int indexP = 0 ; int indexN = 0 ; 
		
		String hql = "SELECT COUNT(*) FROM CustodianBank" ;
		long count = (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if (count<=14) 
			end = (int)count; 
		else end = 14 ; 
		List<CustodianBank> listCustodianBankControlAcd = custodianBankService.getCustodianBanksAcd(index, end);
		List<OrderEntry> listOrderEntry = orderEntryService.getAllOrderEntries();
		
		for (int i = 0; i < listCustodianBankControlAcd.size() ; i++) {
			CustodianBank cb = listCustodianBankControlAcd.get(i);
			OrderEntry od = listOrderEntry.get(i);
			boolean compare = (cb.getCbd_isin().equals(od.getIsn_isin())) &&
					(cb.getCbd_amount() == od.getOde_amount())
					&&(cb.getCbd_tradDate().equals(od.getOde_traddate()))
					&& (cb.getCbd_valueDate().equals(od.getOde_valuedate()))
				    && (cb.getCbd_clientID().equals(od.getOde_clientID())) ;
				
			if (compare) {
					cb.setCbd_message("match");
			}
			else {
				    cb.setCbd_message("not match");
			}
			
		}
		
		List<CustodianBank> listCustodianBankControl = custodianBankService.getCustodianBanks(index, end);
		
		//render reconciliation list to form
		view.addObject("listCustodianBankControl", listCustodianBankControl);
		view.setViewName("dataReconciliationIndex");
		if (count > 14) {
			if (index == 0)
				indexP = -1;
			else 
				indexP = index - 14; 	
			if (index < count)
				indexN = index + 14;
			//render previous next to form
			view.addObject("indexPrevious", indexP);
			view.addObject("indexNext", indexN);
		}
		view.addObject("rowNumber" , count) ; 
		return view;
	}
	
}