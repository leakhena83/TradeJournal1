package com.jwt.controller;

import java.io.IOException;
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
import com.jwt.model.StatisticClientData;
import com.jwt.model.User;
import com.jwt.service.StatisticClientDataService;
import com.jwt.service.UserService;

@Controller
public class StatisticClientDataController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private StatisticClientDataService clientDataService;
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/clientdata" , method = RequestMethod.GET)
	@Transactional
	public ModelAndView listClientData(ModelAndView view,HttpServletRequest request ) throws IOException {
		// index : start of index to fetch from database
		Integer index = Integer.parseInt(request.getParameter("i")) ;
	    String user_name =  request.getParameter("user_name") ;
		User user = userService.getUser(user_name);
		String user_role = user.getUsr_role();
		int user_id = user.getUsr_id() ;
		
		//end : end of index to fetch from database
		int end = 0 ; 
		int indexP = 0 ; int indexN = 0 ; 
		String hql = "SELECT COUNT(*) FROM StatisticClientData" ;
		long count = (Long)sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if (count<=14) 
			end = (int)count; 
		else end = 14 ; 
		List<StatisticClientData> listClientData = clientDataService.getClientDatas(index, end , user_role, user_id);
		//render clientdata list to form
		view.addObject("listClientData", listClientData);
		view.addObject("user_name", user_name);
		view.setViewName("clientDataIndex");
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
		
	    
		view.addObject("user_id" , user_id);		
		view.addObject("rowNumber" , count) ; 
		return view;
	}
	
	//render client data form
	@RequestMapping(value = "/newClientData", method = RequestMethod.GET)
	public ModelAndView newClientData(ModelAndView view , HttpServletRequest request) {
		StatisticClientData clientData = new StatisticClientData();
		Integer user_id = Integer.parseInt(request.getParameter("user_id")) ;
		view.setViewName("clientDataForm");
		//set object to form
		view.addObject("clientData", clientData );
		view.addObject("id", 0);
		view.addObject("user_id", user_id) ;
		
		return view;
	}
	
	// save client data action
	@RequestMapping(value = "/saveDeleteClientData", params = "save", method = RequestMethod.POST)
	public ModelAndView saveClientData(@ModelAttribute StatisticClientData clientData, HttpServletRequest request) throws ParseException {
		SimpleDateFormat formDate = new SimpleDateFormat ("dd/MM/yyyy");
		// retrieve all date string values from POST method 
		String birthDate = request.getParameter("scd_birthday");
		int user_id = clientData.getUsr_id();
		User user = userService.getUser(user_id);
		String user_name = user.getUsr_username();
		
		// convert all dates string value to date type 
		clientData.setScd_birthday(formDate.parse(birthDate));		
		// if client id is 0 then creating clientdata
		if (clientData.getScd_id() == 0) { 
			clientDataService.addClinetData(clientData);
		} else {
			// otherwise updating client data
			clientDataService.updateClientData(clientData);
		}

		//return to client data list
		return new ModelAndView("redirect:/clientdata?i=0&user_id="+user_id+"&user_name="+user_name);
	}
	
	// Show record before deleting 
	@RequestMapping(value = "/deleteClientData", method = RequestMethod.GET)
	public ModelAndView deleteClientData(HttpServletRequest request) {
		int clientdataId = Integer.parseInt(request.getParameter("id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		return new ModelAndView("redirect:/editClientData?id="+ clientdataId+"&user_id="+user_id);
	}
	
	//delete client data action
	@RequestMapping(value = "/saveDeleteClientData" , params = "delete", method = RequestMethod.POST)
	public ModelAndView deleteAction(@ModelAttribute StatisticClientData clientData, HttpServletRequest request) {
		
		int clientDataId = clientData.getScd_id();
		clientDataService.deleteClientData(clientDataId);
		int user_id = clientData.getUsr_id();
		User user = userService.getUser(user_id);
		String user_name = user.getUsr_username();
		
		return new ModelAndView("redirect:/clientdata?i=0&user_id="+user_id+"&user_name="+user_name);
	}

	@RequestMapping(value = "/editClientData", method = RequestMethod.GET)
	public ModelAndView editClientData(HttpServletRequest request) throws ParseException {
		int clientDataId = Integer.parseInt(request.getParameter("id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		StatisticClientData clientData = clientDataService.getClientData(clientDataId);
		ModelAndView view = new ModelAndView("clientDataForm");
		
		//convert date to string with format dd/MM/yyyy
		
		Date birthDate = clientData.getScd_birthday();
		SimpleDateFormat sqlDate = new SimpleDateFormat ("yyyy-MM-dd");
		
		String birthday = sqlDate.format(birthDate);
		String birthdayConvert = birthday.substring(8,10) +"/" + birthday.substring(5,7) +"/" + birthday.substring(0,4) ;

		//assign all object to client data form 
		view.addObject("clientData", clientData );
		view.addObject("birthDate", birthdayConvert );
		view.addObject("id", clientData.getScd_id());
		view.addObject("user_id", user_id );
		
		return view;
	}
}