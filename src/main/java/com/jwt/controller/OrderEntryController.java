package com.jwt.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.jwt.model.ISIN;
import com.jwt.model.OrderEntry;
import com.jwt.service.ISINService;
import com.jwt.service.OrderEntryService;


@Controller
public class OrderEntryController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private OrderEntryService orderentryService;
	
	@Autowired
	private ISINService isinService;
	
	@RequestMapping(value = "/orderentry" , method = RequestMethod.GET)
	@Transactional
	public ModelAndView listOrderEntry(ModelAndView view,HttpServletRequest request ) throws IOException {
		// index : start of index to fetch from database
		Integer index = Integer.parseInt(request.getParameter("i")) ;
		//end : end of index to fetch from database
		int end = 0 ; 
		int indexP = 0 ; int indexN = 0 ; 
		
		String hql = "SELECT COUNT(*) FROM OrderEntry" ;
		long count = (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if (count<=14) 
			end = (int)count; 
		else end = 14 ; 
		List<OrderEntry> listOrderentry = orderentryService.getOrderEntries(index, end);
		
		//render orderentry list to form
		view.addObject("listOrderentry", listOrderentry);
		view.setViewName("orderentryIndex");
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
	
	@RequestMapping(value = "/newOrderEntry", method = RequestMethod.GET)
	public ModelAndView newOrderEntry(ModelAndView view , HttpServletRequest request) {
		DateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		OrderEntry orderentry = new OrderEntry();
		List<ISIN> listIsin = isinService.getAllISIN();
        String isin = request.getParameter("param");
		String hostname = "";
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    view.setViewName("orderentryForm");
		    view.addObject("userId", hostname);
		    
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
		
		String currentDate = formDate.format(date);
		
		//invoke orderEntryForm form 
		view.setViewName("orderentryForm");
		//set object to form
		view.addObject("orderentry", orderentry);
		view.addObject("id", 0);
		view.addObject("traDate", currentDate);
		view.addObject("valueDate", currentDate);
		view.addObject("listIsin",listIsin);
		
		 if (isin.equals("st")) 
			 view.addObject("isin", "null");
	        
		 else { 
			   String securityName = isinService.getOneISIN(isin).getIsn_securityname();
			   String currency = isinService.getOneISIN(isin).getIsn_currency();
			   view.addObject("isin", isin);
			   view.addObject ("securityName",securityName);
			   view.addObject ("currency",currency);
		 }
		
		return view;
	}
	
	// save (add or edit) order entry action
	@RequestMapping(value = "/saveDeleteOrderEntry", params = "save", method = RequestMethod.POST)
	public ModelAndView saveOderEntry(@ModelAttribute OrderEntry orderentry, HttpServletRequest request) throws ParseException {
		
		SimpleDateFormat formDate = new SimpleDateFormat ("dd/MM/yyyy");
		// retrieve all date string values from POST method 
		String executeDate = request.getParameter("ode_dateexecution");
		String tradDate = request.getParameter("ode_traddate");
		String valueDate = request.getParameter("ode_valuedate");
		String validDate = request.getParameter("ode_validdate");
		String quantity = request.getParameter("ode_quantity");
		String price = request.getParameter("ode_price");
	
		// convert all dates string value to date type 
		orderentry.setOde_dateexecution(formDate.parse(executeDate));
		orderentry.setOde_traddate(formDate.parse(tradDate));
		orderentry.setOde_valuedate(formDate.parse(valueDate));
		orderentry.setOde_validdate(formDate.parse(validDate));
		
		if (quantity.isEmpty()) orderentry.setOde_quantity("0");
		if (price.isEmpty()) orderentry.setOde_price("0.0");
		
		// if orderentry id is 0 then creating orderentry
		if (orderentry.getOde_id() == 0) { 
			orderentryService.addOrderEntry(orderentry);
		} else {
			// otherwise updating orderentry
			orderentryService.updateOrderEntry(orderentry);
		}
		//return to orderentry list
		return new ModelAndView("redirect:/orderentry?i=0");
	}
	
	// Show record before deleting 
	@RequestMapping(value = "/deleteOrderEntry", method = RequestMethod.GET)
	public ModelAndView deleteOrderEntry(HttpServletRequest request) {
		int orderentryId = Integer.parseInt(request.getParameter("id"));
		String isinId = (request.getParameter("isin"));
		return new ModelAndView("redirect:/editOrderEntry?id="+orderentryId+"&isin="+ isinId);
	}
	
	//delete entry action
	@RequestMapping(value = "/saveDeleteOrderEntry" , params = "delete", method = RequestMethod.POST)
	public ModelAndView deleteAction(@ModelAttribute OrderEntry orderentry, HttpServletRequest request) {
		
		int orderentryId = orderentry.getOde_id();
		orderentryService.deleteOrderEntry(orderentryId);
		
		return new ModelAndView("redirect:/orderentry?i=" + 0);
	}

	@RequestMapping(value = "/editOrderEntry", method = RequestMethod.GET)
	public ModelAndView editOrderentry(HttpServletRequest request) throws ParseException {
		int orderentryId = Integer.parseInt(request.getParameter("id"));
		String isin = request.getParameter("isin");
		List<ISIN> listIsin = isinService.getAllISIN();
		OrderEntry orderentry = orderentryService.getOrderEntry(orderentryId);
		ModelAndView view = new ModelAndView("orderentryForm");
		
		//convert date to string with format dd/MM/yyyy
		
		Date executeDate = orderentry.getOde_dateexecution() ;
		Date tradDate = orderentry.getOde_traddate() ;
		Date valueDate = orderentry.getOde_valuedate();
		Date validDate = orderentry.getOde_validdate() ;
		
		SimpleDateFormat sqlDate = new SimpleDateFormat ("yyyy-MM-dd");
		String exedate = sqlDate.format(executeDate);
		String tradate = sqlDate.format(tradDate) ;
		String vludate = sqlDate.format(valueDate);
		String vliDate = sqlDate.format(validDate);
		
		String exedateConvert = exedate.substring(8,10) +"/" + exedate.substring(5,7) +"/" + exedate.substring(0,4) ;
		String tradateConvert = tradate.substring(8,10) +"/" + tradate.substring(5,7) +"/" + tradate.substring(0,4) ;
		String vludateConvert = vludate.substring(8,10) +"/" + vludate.substring(5,7)+ "/" + vludate.substring(0,4) ;
		String vlidateConvert = vliDate.substring(8,10) +"/" + vliDate.substring(5,7)+ "/" +vliDate.substring(0,4) ;
		String securityName = isinService.getOneISIN(isin).getIsn_securityname();
		String currency = isinService.getOneISIN(isin).getIsn_currency();
		//assign all object to orderentry form 
		view.addObject("orderentry", orderentry);
		view.addObject("executeDate", exedateConvert);
		view.addObject("tradDate", tradateConvert);
		view.addObject("vlueDate", vludateConvert);
		view.addObject("vlidDate", vlidateConvert);
		view.addObject("id", orderentry.getOde_id());
	
		view.addObject("listIsin",listIsin);
		view.addObject("isin", isin);
		view.addObject ("securityName",securityName);
		view.addObject ("currency",currency);
		return view;
	}

}