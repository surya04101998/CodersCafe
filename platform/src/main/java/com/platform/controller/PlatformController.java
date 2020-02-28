package com.platform.controller;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;


import com.platform.model.LoginBean;
import com.platform.model.User;
import com.platform.services.MailHandler;
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
		public String signup(@Valid @ModelAttribute("loginDetails")LoginBean loginBean,BindingResult br,ModelMap map) {
			
			User us=new User();
			us.setUsername(loginBean.getUsername());
			us.setPassword(loginBean.getPassword());
			us.setEmailId(loginBean.getEmailId());
			
			if(br.hasErrors()) {
				return "SignUpPage";
				
			}
			if(userHandler.addUser(us)) {
				try {
					MailHandler.sendMail(loginBean.getEmailId(), "Welcome", "Thanks for signing up into Coders cafe");
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return "success";
			}
			return "SignUpPage";
		}
		
		@RequestMapping(value="/signup",method=RequestMethod.POST)
		public String addUser(@ModelAttribute("loginDetails")LoginBean loginBean,BindingResult br,ModelMap map) {
			return "SignUpPage";
		}
		
		
}
