package com.ffe.title.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffe.common.exception.GTSException;
import com.ffe.title.message.SearchCriteria;

@Controller
public class FilmEstimateController {
	
	private static final Logger log = LoggerFactory.getLogger(FilmEstimateController.class);	


	@RequestMapping(value = "/loadEstimatehome")
	public String getEstimateHome(Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside FilmEstimateController.getEstimateHome"+request.getRequestURI());
		try {		 
			model.addAttribute("searchcriteria", new SearchCriteria());		
		
		} catch(Exception e){
			log.error("Exception Occured in FilmEstimateController.getEstimateHome : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "estimate_home"; 
	}


}
