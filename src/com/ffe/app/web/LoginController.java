package com.ffe.app.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ffe.app.service.impl.UserService;
import com.ffe.common.exception.GTSException;
import com.ffe.common.framework.model.UserProfile;
import com.ffe.title.web.FilmController;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(FilmController.class);	

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) throws GTSException {
	
		System.out.println("-->login request");
		return "login";
	}
	
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String register(Model model, HttpServletRequest request) throws GTSException {
		System.out.println("-->register request");
		UserProfile profile = new UserProfile();
		model.addAttribute("UserProfile", profile);
		System.out.println("request came here ");
		return "registration";
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String addUser(Model model, HttpServletRequest request) throws GTSException {
		System.out.println("-->add user request");
		
		UserProfile profile = new UserProfile();
		model.addAttribute("UserProfile", profile);
		System.out.println("request came here ");
		return "registration";
	}
	
		
	
}
