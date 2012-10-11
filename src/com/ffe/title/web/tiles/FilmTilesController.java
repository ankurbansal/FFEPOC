package com.ffe.title.web.tiles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffe.common.exception.GTSException;
import com.ffe.title.model.Title;
import com.ffe.title.service.TitleService;


@Controller
public class FilmTilesController {
	
	@Autowired
	TitleService titleService;
	
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	private static final Logger log = LoggerFactory.getLogger(FilmTilesController.class);

	@RequestMapping(value = "/addtitle")
	public String saveTitle(@ModelAttribute(value="title")Title title, BindingResult result,
			Model model, HttpServletRequest request) throws GTSException{		
		log.info("Inside FilmTilesController.addTitle");
		try {			
			/*String myBeanResources[] = new String[] {"spring-app-context.xml"};		
			ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
			TitleService titleService = (TitleService) ctx.getBean("titleService");*/
			
			Title title_created =  titleService.saveTitle(title);		
			model.addAttribute("title", title_created);	
			System.out.println("------------>"+title_created);
			
		} catch(Exception e){
			log.error("Exception Occured in FilmTilesController.addTitle : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "view_title";
	}
	
	
	@RequestMapping(value = "/searchtitle")
	public String searchTitle(@ModelAttribute(value="title")Title title, BindingResult result,
			Model model, HttpServletRequest request) throws GTSException{		
		log.info("Inside FilmTilesController.addTitle");
		try {			
			titleService.saveTitle(title);		
			System.out.println("title id "+ title);
			
		} catch(Exception e){
			log.error("Exception Occured in FilmTilesController.addTitle : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "title_results";
	}
	
	
	@RequestMapping(value = "/edittitle")
	public String edittitle(@RequestParam(value = "titleId") long titleID, Model model, HttpServletRequest request) throws GTSException{		
		log.info("Inside FilmTilesController.addTitle");
		try {			
			Title title = titleService.getTitle(titleID);
			model.addAttribute("title", title);					
		} catch(Exception e){
			log.error("Exception Occured in FilmTilesController.addTitle : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "view_title";
	}




}
