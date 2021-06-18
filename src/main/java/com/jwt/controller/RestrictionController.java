package com.jwt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
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

import com.jwt.model.RestrictionControl;
import com.jwt.service.RestrictionControlService;


@Controller
public class RestrictionController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private RestrictionControlService restrictionControlService;
	
	@RequestMapping(value = "/restrictionControl" , method = RequestMethod.GET)
	@Transactional
	public ModelAndView listRestrictionControl(ModelAndView view,HttpServletRequest request ) throws IOException {
		// index : start of index to fetch from database
		Integer index = Integer.parseInt(request.getParameter("i")) ;
		//end : end of index to fetch from database
		int end = 0 ; 
		int indexP = 0 ; int indexN = 0 ; 
		
		String hql = "SELECT COUNT(*) FROM RestrictionControl" ;
		long count = (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if (count<=14) 
			end = (int)count; 
		else end = 14 ; 
		List<RestrictionControl> listRestrictionControl = restrictionControlService.getRegistrionControls(index, end);
		for (int i = 0; i <listRestrictionControl.size() ; i++) {
			Date date = listRestrictionControl.get(i).getRcs_date();
			
			SimpleDateFormat sqlDate = new SimpleDateFormat ("yyyy/MM/dd");
			String dateStr = sqlDate.format(date);
			
			String dateConvert = dateStr.substring(8,10) +"/" + dateStr.substring(5,7) +"/" + dateStr.substring(0,4) ;
			listRestrictionControl.get(i).setDate(dateConvert);
		}
		
		//render restrictionControl list to form
		view.addObject("listRestrictionControl", listRestrictionControl);
		view.setViewName("restrictionControlIndex");
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
	
	@RequestMapping(value = "/editRestrictionControl", method = RequestMethod.GET)
	public ModelAndView editRestrictionControl(HttpServletRequest request) throws ParseException {
		int restrictionControlId = Integer.parseInt(request.getParameter("id"));
		
		RestrictionControl restrictionControl = restrictionControlService.getRestrictionControl(restrictionControlId);
		ModelAndView view = new ModelAndView("restrictionControlForm");
		
		//convert date to string with format dd/MM/yyyy
		Date date = restrictionControl.getRcs_date();
		
		SimpleDateFormat sqlDate = new SimpleDateFormat ("yyyy/MM/dd");
		String dateStr = sqlDate.format(date);
		
		String dateConvert = dateStr.substring(8,10) +"/" + dateStr.substring(5,7) +"/" + dateStr.substring(0,4) ;
		
		
		//assign all object to restrictionControl form 
		view.addObject("restrictionControl", restrictionControl);
		view.addObject("date", dateConvert);
	
		return view;
	}
	// save restriction control system action
	@RequestMapping(value = "/saveDeleteRestrictionControl", params = "save", method = RequestMethod.POST)
	public ModelAndView saveRestrictionControl(@ModelAttribute RestrictionControl restrictionControl, HttpServletRequest request) throws ParseException {
		// if restrictioncontrol id is 0 then creating restrictioncontrol
		SimpleDateFormat formDate = new SimpleDateFormat ("dd/MM/yyyy");
		// retrieve all date string values from POST method 
		String date = request.getParameter("rcs_date");
		// convert dates string value to date type 
		restrictionControl.setRcs_date(formDate.parse(date));
		float actual = Float.parseFloat(request.getParameter("rcs_actual"));
		float neutral = Float.parseFloat(request.getParameter("rcs_neutral"));	
		float min = Float.parseFloat(request.getParameter("rcs_min"));
		float max = Float.parseFloat(request.getParameter("rcs_max"));
		float vsnetural = actual - neutral ;
		float vsmin = actual - min ;
		float vsmax = actual - max ;
	
		restrictionControl.setRcs_min(min );
		restrictionControl.setRcs_max(max);
		restrictionControl.setRcs_neutral(neutral);
		restrictionControl.setRcs_vsneutral(vsnetural);
		restrictionControl.setRcs_vsmin(vsmin);
		restrictionControl.setRcs_vsmax(vsmax);	
		
		if ((vsmin < min) || (vsmax > max)) restrictionControl.setRcs_message("breach !!");
		// update restriction control 
		restrictionControlService.updateRestrictionControl(restrictionControl);
		
		//return to orderentry list
		return new ModelAndView("redirect:/restrictionControl?i=0");
	}
	
	// Show record before deleting 
	@RequestMapping(value = "/deleteRestrictionControl", method = RequestMethod.GET)
	public ModelAndView deleteRestrictionContol(HttpServletRequest request) {
		int restrictionControlId = Integer.parseInt(request.getParameter("id"));
		return new ModelAndView("redirect:/editRestrictionControl?id="+restrictionControlId);
	}
	
	//delete restrictionControl action
	@RequestMapping(value = "/saveDeleteRestrictionControl" , params = "delete", method = RequestMethod.POST)
	public ModelAndView deleteAction(@ModelAttribute RestrictionControl restrictionControl) {
		int restrictionControlId = restrictionControl.getRcs_id();
		restrictionControlService.deleteRestrictionControl(restrictionControlId);
		return new ModelAndView("redirect:/restrictionControl?i=" + 0);
	}

	

}