package com.ffe.title.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class FilmController {
	
	private static final Logger log = LoggerFactory.getLogger(FilmController.class);
	
	/*private MessageSource messageSource; 
 
	private PersonService personService;
	
	private PersonValidator personValidator;
	
	@Autowired
	public void setPersonValidator(PersonValidator personValidator) {
		this.personValidator = personValidator;
	}

	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	private AddressService addressService;
	
	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(ReferenceType.class, new ReferenceTypeEditor());
		binder.setValidator(new PersonValidator());
	}
	
	

	@RequestMapping(value = "/getPerson")
	public String getPerson(@RequestParam(value = "personId") long personId,
			Model model) throws AddressBookException {
		log.info("Inside PersonController.getPerson input " + personId);
		try {
			Person person = personService.getPerson(personId);			
			populateModelWithReferenceTypes(model);
			model.addAttribute("person", person);
		} catch (AddressBookException e) {
			e.printStackTrace();
			throw e;
		}
		return "personDetails";
	}

	@RequestMapping(value = "/findPerson")
	public String findPerson(
			@RequestParam(value = "searchString", required = false) String searchString,
			Model model, HttpServletRequest request)
			throws AddressBookException {
		log.info("Inside PersonController.findPerson ");
		try {
			if (searchString != null && !"".equalsIgnoreCase(searchString)) {
				List<Person> persons = personService.findPerson(searchString);
				if (persons != null && persons.size() > 0) {
					model.addAttribute("persons", persons);
				} else {
					String[] dynamicMessage = { searchString };
					String defaultMessage = "No result found. Modify the search condition and try again";
					String message = messageSource.getMessage(
							"person.search.noresult", dynamicMessage,
							defaultMessage, Locale.US);
					model.addAttribute("message", message);
				}
				model.addAttribute("searchString", searchString);
			}
		} catch (AddressBookException e) {
			e.printStackTrace();
			throw e;
		}
		return "findPerson";
	}

	private List<SearchCriteria> populatePersonSearchCriteria(Model model,
			HttpServletRequest request) {
		return null;
	}

	@RequestMapping(value = "/savePerson")
	public String savePerson(@ModelAttribute(value = "person") Person person,BindingResult result,
			Model model, HttpServletRequest request)
			throws AddressBookException {
		log.info("Inside PersonController.savePerson person : " + person);
		
		String loggedInUser = null;
		try {
			if (person != null) {
				//loggedInUser = ControllerUtil.getLoggedInUser();
				log.debug("Person Name : " + person.getFirstName());
				if (person.getPersonId() == 0) {
					person.setCreatedBy(loggedInUser);
					person.setCreatedDateTime(new Date());
				}
				person.setLastUpdatedBy(loggedInUser);
				person.setLastUpdatedDateTime(new Date());
				log.debug("Phones : "+person.getPhones());
				log.debug("Emails : "+person.getEmails());
		
				personValidator.validate(person, result);
			}	
			log.debug("result "+ result);
			
			if(result!= null){
				log.debug("result-----------> "+ result.hasErrors());
			}
			if(null!=result && result.hasErrors()){
				
			}else{
				person = personService.savePerson(person);
			}
			log.debug("entering the savePerson2");
			model.addAttribute("person", person);
			populateModelWithReferenceTypes(model);
		} catch (AddressBookException e) {
			e.printStackTrace();
			throw e;
		}
		
		log.debug("entering the savePerson3");
		return "personDetails";
		
	}

	@RequestMapping(value = "/newPerson")
	public String newPerson(Model model) throws AddressBookException {
		log.info("Inside PersonController.newPerson : ");
		model.addAttribute("person", new Person());
		populateModelWithReferenceTypes(model);
		return "personDetails";
	}
	
	private void populateModelWithReferenceTypes(Model model) throws AddressBookException{
		try{
		model.addAttribute("phoneTypes", addressService.getPhoneTypes());
		model.addAttribute("emailTypes", addressService.getEmailTypes());
		}catch (AddressBookException e) {
			log.error("Exception Occured in populateModelWithReferenceTypes : ",e);
			//e.printStackTrace();
			throw e;
		}
	}*/
}
