package com.ffe.title.web.overlay;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.model.Estimate;
import com.ffe.estimate.model.EstimateCosting;
import com.ffe.estimate.service.EstimateService;
import com.ffe.service.service.DigitalCostService;
import com.ffe.title.message.SearchCriteria;
import com.ffe.title.model.Title;


@Controller
public class FilmServicePricingController {
	
	@Autowired
	private DigitalCostService digitalCostService ;
	
	@Autowired
	private EstimateService estimateService ;	
	
	  
	public void setDigitalCostService(DigitalCostService digitalCostService) {
		this.digitalCostService = digitalCostService;
	}

	public void setEstimateService(EstimateService estimateService) {
		this.estimateService = estimateService;
	}

	private static final Logger log = LoggerFactory.getLogger(FilmServicePricingController.class);
	
	@RequestMapping(value = "/loadServicePricingEstimateForm")
	public String getServicePricingEstimateForm(Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside FilmServicePricingController.getServicePricingEstimateForm"+request.getRequestURI());
		try {			 
			model.addAttribute("estimate", new Estimate());	
			model.addAttribute("title", new Title());	
			populateModelWithReferenceTypes(model);				
		} catch(Exception e){
			log.error("Exception Occured in FilmServicePricingController.getServicePricingEstimateForm : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "film_service_pricing_overlay"; 
	}


	@RequestMapping(value = "/saveServicePricingEstimate")
	public String saveServicePricingEstimate(@ModelAttribute(value="estimate")Estimate estimate, BindingResult result,
			Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside FilmServicePricingController.saveServicePricingEstimate"+request.getRequestURI());
		try {
			 log.debug("estimate.getLstEstimateCosting().size()----------------->"+estimate.getLstEstimateCosting().size());	
			 log.debug("estimate.getLstEstimateCosting().size()----------------->"+estimate.toString());
			 
			 for(EstimateCosting estCos: estimate.getLstEstimateCosting()){
				 estCos.setEstimate(estimate);				 
			 }			 			 
			 estimateService.saveEstimate(estimate);	
			 
			 model.addAttribute("searchcriteria", new SearchCriteria());			 		
		} catch(Exception e){
			log.error("Exception Occured in FilmServicePricingController.saveServicePricingEstimate : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "estimate_home"; 
	}
	
	private void populateModelWithReferenceTypes(Model model) throws GTSException {			
		model.addAttribute("digitalFeatureServiceList", digitalCostService.lstServiceByCostType(1L));
		model.addAttribute("digitalTrailerServiceList", digitalCostService.lstServiceByCostType(2L));
		model.addAttribute("dubbingServiceList", digitalCostService.lstServiceByCostType(3L));
		model.addAttribute("otherServiceList", digitalCostService.lstServiceByCostType(4L));
		model.addAttribute("allServiceList", digitalCostService.lstAllService());	
	}
}
