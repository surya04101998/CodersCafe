package com.platform.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.platform.model.LoginBean;
import com.platform.model.User;
import com.platform.services.UsersHandler;
@Controller
public class PlatformController {
	
	


	

		@Autowired
		private UsersHandler userHandler;
		
		
		
		
		@RequestMapping(value ="/home")
		public String homepage(@ModelAttribute("loginDetails")LoginBean loginBean) {
			
			
			return "index";
		}
		
		
		@RequestMapping(value="/addUser",method=RequestMethod.POST)
		public String signup(@ModelAttribute("loginDetails")LoginBean loginBean,ModelMap map) {
			
			User us=new User();
			us.setUsername(loginBean.getUsername());
			us.setPassword(loginBean.getPassword());
			us.setEmailId(loginBean.getEmailId());
			if(userHandler.addUser(us)) {
				return "success";
			}
			map.addAttribute("message", "some error with signup");
			return "SignUpPage";
		}
		
		@RequestMapping(value="/signup",method=RequestMethod.POST)
		public String addUser(@ModelAttribute("loginDetails")LoginBean loginBean,ModelMap map) {
			return "SignUpPage";
		}
		
		
}
