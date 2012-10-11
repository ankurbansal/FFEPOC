package com.ffe.title.web.tiles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffe.common.exception.GTSException;
import com.ffe.title.model.Title;
import com.ffe.title.service.TitleService;


@Controller
public class FilmTilesController {

	private static final Logger log = LoggerFactory.getLogger(FilmTilesController.class);

	@RequestMapping(value = "/addtitle")
	public String addTitle(@ModelAttribute(value="title")Title title, BindingResult result,
			Model model, HttpServletRequest request) throws GTSException{		
		log.info("Inside FilmTilesController.addTitle");
		try {			
			String myBeanResources[] = new String[] {"spring-app-context.xml"};		
			ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
			TitleService titleService = (TitleService) ctx.getBean("titleService");
			
			titleService.saveTitle(title);		
			System.out.println("title id "+ title);
			
		} catch(Exception e){
			log.error("Exception Occured in FilmTilesController.addTitle : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "tiles_general_layout";
	}

}
