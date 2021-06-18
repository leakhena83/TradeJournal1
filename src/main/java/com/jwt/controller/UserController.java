package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.User;
import com.jwt.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginform(ModelAndView view) {
		User user = new User();
		view.addObject("user", user);
		view.setViewName("login");
		return view;
	}
	
	@RequestMapping(value = "/logIn", method = RequestMethod.POST) 
	public ModelAndView logIn(@ModelAttribute User user) {
		
		// if username is correct 
		if (userService.getUser(user.getUsr_username()) != null) { 
		
			// if password is correct
			if (userService.getPassword(user.getUsr_password()) != null) {
				ModelAndView view = new ModelAndView("/home");
				view.addObject("user" , user.getUsr_username()); 
				User usr = userService.getUser(user.getUsr_username()) ;
				view.addObject("user_id", usr.getUsr_id()) ;
				view.addObject("user_name", usr.getUsr_username()) ;
				view.addObject("user_role",usr.getUsr_role());
				return view ;
			}
			else {
				ModelAndView view = new ModelAndView("/login");
				view.addObject("message", "Password is incorrect!!");
				return view; 
			}
		
		} 
		// if username is not correct 
		else {
			ModelAndView view = new ModelAndView("/login");
			view.addObject("message", "Username is incorrect!!");
			return view; 
		}
		
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView view) {
		view.setViewName("home");
		return view;
	}

}
