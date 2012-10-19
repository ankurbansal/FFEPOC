package com.ffe.app.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ffe.app.service.impl.UserService;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;

@Controller
public class LoginController {

	
		

	@Autowired
	private UserService userService;
	


	private static final Logger log = LoggerFactory.getLogger(LoginController.class);	

	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) throws GTSException {
	
		System.out.println("-->login request");
		return "login";
	}
	
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest request) throws GTSException {
		System.out.println("-->register request");
		UserProfile profile = new UserProfile();
		System.out.println("userService.lstTerritory()"+ userService.lstTerritory().size());
		model.addAttribute("territorys", userService.lstTerritory());
		model.addAttribute("UserProfile", profile);
		System.out.println("request came here ");
		return "registration";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String addUser(@ModelAttribute(value="UserProfile")UserProfile profile, BindingResult result,
			Model model, HttpServletRequest request) throws GTSException {
		try{
		System.out.println("-->add user request");
		profile=(UserProfile) userService.saveUser(profile);
		System.out.println("userService.lstTerritory()"+ userService.lstTerritory().size());
		model.addAttribute("territorys", userService.lstTerritory());
		model.addAttribute("UserProfile", profile);
		System.out.println("-->exiting");
		}catch (Exception e) {
			e.printStackTrace();
			throw new GTSException(e.getLocalizedMessage(),e.getMessage());
		}
		return "registration";
	}
	
		
	
}
