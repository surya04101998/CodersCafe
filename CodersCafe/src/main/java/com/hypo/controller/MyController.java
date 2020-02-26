package com.hypo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hypo.model.User;
import com.hypo.service.UsersHandler;


@Controller
public class MyController {

	@Autowired
	private UsersHandler userHandler;
	
	
	
	
	@RequestMapping(value ="/home")
	public String homepage(@ModelAttribute("currentUser")User us,ModelMap map) {

		return "index";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("currentUser")User us,ModelMap map,HttpSession sess) {
		
		if(userHandler.authentication(us)) {
			sess.setAttribute("currentUser", us);
			return "success";
		}
		map.addAttribute("msg", "invalid username or password");
		
		
		return "index";
		
	}
	
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String signup(@ModelAttribute("currentUser")User user,ModelMap map) {
		if(userHandler.addUser(user)) {
			return "success";
		}
		map.addAttribute("message", "some error with signup");
		return "SignUpPage";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("currentUser")User user,ModelMap map) {
		return "SignUpPage";
	}


}
