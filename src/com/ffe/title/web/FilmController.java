package com.ffe.title.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffe.common.exception.GTSException;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;

@Controller
public class FilmController {
	
	private static final Logger log = LoggerFactory.getLogger(FilmController.class);	
	
	@RequestMapping(value = "/titlehome")
	public String getTitleHome(Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside FilmController.getTitleHome");
		try {			
			model.addAttribute("searchcriteria", new SearchCriteria());
			model.addAttribute("title", new Title());
			populateModelWithReferenceTypes(model);		
		} catch(Exception e){
			log.error("Exception Occured in FilmController.getTitleHome : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "add_title"; 
	}

	private static void populateModelWithReferenceTypes(Model model) {
		
		
	}
}
