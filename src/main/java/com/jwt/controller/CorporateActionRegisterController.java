package com.jwt.controller;

import java.io.IOException;
import java.text.ParseException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.CorporateActionRegister;
import com.jwt.service.CorporateActionRegisterService;

@Controller
public class CorporateActionRegisterController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CorporateActionRegisterService corporateActionRegisterService;
	
	@RequestMapping(value = "/corporationActionRegister" , method = RequestMethod.GET)
	@Transactional
	public ModelAndView listRestrictionControl(ModelAndView view,HttpServletRequest request ) throws IOException {
		// index : start of index to fetch from database
		Integer index = Integer.parseInt(request.getParameter("i")) ;
		//end : end of index to fetch from database
		int end = 0 ; 
		int indexP = 0 ; int indexN = 0 ; 
		
		String hql = "SELECT COUNT(*) FROM CorporateActionRegister" ;
		long count = (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if (count<=14) 
			end = (int)count; 
		else end = 14 ; 
		
		List<CorporateActionRegister> listCorporateActionRegister = corporateActionRegisterService.getCorporateActionReigsters(index, end) ;
				
		//render restrictionControl list to form
		view.addObject("listCorporateActionRegister", listCorporateActionRegister);
		view.setViewName("CorporateActionRegisterIndex");
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
		return view ;
	    }
	
	@RequestMapping(value = "/editCorporateActionRegister", method = RequestMethod.GET)
	public ModelAndView editRestrictionControl(HttpServletRequest request) throws ParseException {
		int corporateActionRegisterId = Integer.parseInt(request.getParameter("id"));
		
		CorporateActionRegister corporateActionRegister = corporateActionRegisterService.getCorporateActionReigster(corporateActionRegisterId);
		ModelAndView view = new ModelAndView("CorporateActionRegisterForm");
		
		//assign all object to corporate action register form 
		view.addObject("corporateActionRegister", corporateActionRegister);
	
		return view;
	}
	
	// Show record before deleting 
	@RequestMapping(value = "/deleteCorporateActionRegister", method = RequestMethod.GET)
	public ModelAndView deleteRestrictionContol(HttpServletRequest request) {
		int corporateActionRegisterId = Integer.parseInt(request.getParameter("id"));
		return new ModelAndView("redirect:/editCorporateActionRegister?id="+corporateActionRegisterId);
		}
		
	//delete restrictionControl action
	@RequestMapping(value = "/deleteCorporateActionRegister" , method = RequestMethod.POST)
	public ModelAndView deleteAction(@ModelAttribute CorporateActionRegister corporateActionRegister) {
		int corporateActionRegisterId = corporateActionRegister.getCar_id();
		corporateActionRegisterService.deleteCorporateActionRegister(corporateActionRegisterId);
		return new ModelAndView("redirect:/corporationActionRegister?i=" + 0);
		}
	
}