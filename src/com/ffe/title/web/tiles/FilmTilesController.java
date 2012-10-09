package com.ffe.title.web.tiles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffe.common.exception.GTSException;


@Controller
public class FilmTilesController {

	private static final Logger log = LoggerFactory.getLogger(FilmTilesController.class);

	/*private BusinessEntityService businessEntityService; 
	@Autowired
	public void setBusinessEntityService(BusinessEntityService businessEntityService) {
		this.businessEntityService = businessEntityService;
	}	

	private AddressService addressService;	
	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	private MessageSource messageSource;
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private BusinessEntityValidator businessEntityValidator ;	
	@Autowired
	public void setBusinessEntityValidator(
			BusinessEntityValidator businessEntityValidator) {
		this.businessEntityValidator = businessEntityValidator;
	}

	private ControllerUtil controllerUtil;
	@Autowired
	public void setControllerUtil(ControllerUtil controllerUtil) {
		this.controllerUtil = controllerUtil;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantUtil.YEAR_FORMAT);
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		binder.registerCustomEditor(ReferenceType.class, new ReferenceTypeEditor());
		//binder.registerCustomEditor(PartyAddress.class, new PartyAddressPropertyEditor());
		binder.setValidator(businessEntityValidator);
	}

	@RequestMapping(value = "/tiles_getBusinessEntity")
	public String getBusinessEntity(@RequestParam(value = "businessEntityId") long businessEntityId,
			Model model, HttpServletRequest request) throws AddressBookException{
		log.info("Inside BusinessEntityTilesController.getBusinessEntity input "
				+ businessEntityId);
		try {
			BusinessEntity businessEntity = businessEntityService.getBusinessEntity(businessEntityId);
			log.debug("Contacts in BE : "+ businessEntity.getContacts());
			populateModelWithReferenceTypes(model);
			businessEntity.setCommentsToDelete(null);
			businessEntity.setCommentsToUpdate(null);
			model.addAttribute("businessEntity", businessEntity);
			model.addAttribute("searchBEString", request.getParameter("searchBEString"));
			model.addAttribute("selectedBEId", businessEntityId);
		} catch (AddressBookException e) {
			log.error("AddressBookException caught in BusinessEntityTilesController.getBusinessEntity : ",e);
			throw e;
		}catch(Exception e){
			log.error("Exception Occured in BusinessEntityTilesController.getBusinessEntity : ",e);
			throw new AddressBookException(e.getMessage(),e.getCause());
		}
		return "tiles_loadAddressBook";
	}


	@RequestMapping(value = "/tiles_submitBusinessEntity")
	public String submitBusinessEntity(@ModelAttribute(value = "businessEntity") BusinessEntity businessEntity,
			BindingResult result, Model model, HttpServletRequest request)
	throws AddressBookException {
		log.info("Inside BusinessEntityTilesController.submitBusinessEntity ");
		String operation = null;
		try {
			operation = request.getParameter("operation");
			log.debug("Method Operation -->" + operation);
			if ("saveBusinessEntity".equals(operation) || null == operation || "createBusinessEntity".equals(operation)) {
				saveBusinessEntity(businessEntity, result, model, request);
			} else if ("deleteBusinessEntity".equals(operation)){
				deleteBusinessEntity(businessEntity,result,model,request);
			}

		} catch (AddressBookException e) {
			log.error("error caught in BusinessEntityTilesController.submitBusinessEntity",e);
			throw e;
		}
		return "tiles_loadAddressBook";
	}


	public void saveBusinessEntity(BusinessEntity businessEntity,
			BindingResult result,
			Model model,HttpServletRequest request)throws AddressBookException {
		log.info("Entering BusinessEntityTilesController.saveBusinessEntity ");
		List<PartyAddress> partyAddresses =null;
		List<Contact> contacts = null;
		boolean isCreateBusinessEntity = false;
		try {
			if (businessEntity != null) {

				if("createBusinessEntity".equals(request.getParameter("operation"))){
					businessEntity.setIsCreate(true);
				}else
				{
					businessEntity.setIsCreate(false);
				}

				partyAddresses = businessEntity.getPartyPhysicalAddresses();
				contacts = businessEntity.getContacts();
				if(contacts!=null && contacts.size()>0){
					for(Contact contact : contacts){
						log.info("contact class -- "+contact.getClass());
						log.info("contact -- "+contact.getFirstName()+" "+contact.getLastName());
					}
				}
				controllerUtil.populatePartyPhysicalAddressFromRequest(partyAddresses, request);


				List<Phone>  phones =controllerUtil.removeEmptyPhoneNumbers(businessEntity.getPhones());
				businessEntity.setPhones(phones);
				List<Email>  emails = controllerUtil.removeEmptyEmails(businessEntity.getEmails());
				businessEntity.setEmails(emails);

				businessEntityValidator.validate(businessEntity, result);

				if(result!= null){
					log.debug("result-----------> "+ result.hasErrors());
				}
				if(null==result || !result.hasErrors()){
					log.debug("Business Entity Name : " + businessEntity.getName());
					if("createBusinessEntity".equals(request.getParameter("operation"))){
						businessEntity.setBusinessEntityId(0);
						businessEntity.setPartyId(0);
						businessEntity.setPartyAddresses(null);
						businessEntity.setContacts(null);
						businessEntity.setPostApprovalUpdate(false);
						businessEntity.setCommentsToDelete(null);
						businessEntity.setCommentsToUpdate(null);
						businessEntity.setCommentsToUpdate(null);

						List<Phone> newPhones = businessEntity.getPhones();
						if (phones != null && newPhones.size() >0){
							for(Phone phone:phones){
								phone.setPhoneId(0);
							}
						}
						List<Email> newEmails = businessEntity.getEmails();
						if (emails != null && newEmails.size() >0){
							for(Email email:emails){
								email.setEmailId(0);
							}
						}
					}
										else
					{

						String approvalStatus = controllerUtil.getApprovalStatus(businessEntity.getBusinessEntityId(), ConstantUtil.BUSINESS_ENTITY);
						log.debug("After getting the approval Status from DB"+approvalStatus);
						if("Y".equalsIgnoreCase(approvalStatus))
						{
							businessEntity.setPostApprovalUpdate(true);
						}
						else
						{
							businessEntity.setPostApprovalUpdate(false);
						}
					}

					controllerUtil.setDTOCommonProperties(businessEntity);
					if(!("createBusinessEntity".equals(request.getParameter("operation")))){
						log.debug("In update Part BEtilescontroller ------>");
						String approvalStatus = controllerUtil.getApprovalStatus(businessEntity.getBusinessEntityId(), ConstantUtil.BUSINESS_ENTITY);
						log.debug("After getting the approval Status from DB"+approvalStatus);
						if("Y".equalsIgnoreCase(approvalStatus))
						{
							businessEntity.getApprovalStatus().getApprovalStatus().setId(ConstantUtil.APPROVAL_STATUS_PENDING_FOR_UPDATE);
							//businessEntity.setPostApprovalUpdate(true);
						}
						else
						{
							businessEntity.getApprovalStatus().getApprovalStatus().setId(ConstantUtil.DEFAULT_APPROVAL_STATUS_ID);
						}

					}
					if (businessEntity.getBusinessEntityId() == 0) {
						businessEntity.setCreatedBy(loggedInUser);
					}
					businessEntity.setLastUpdatedBy(loggedInUser);					
					businessEntity = businessEntityService.saveBusinessEntity(businessEntity);
					log.debug("getCommentsToDelete in dto-->"+businessEntity.getCommentsToDelete());
					log.debug("getCommentsToUpdate in dto-->"+businessEntity.getCommentsToUpdate());
					businessEntity.setContacts(contacts);
					businessEntity.setPartyPhysicalAddresses(partyAddresses);
					//businessEntity = businessEntityService.getBusinessEntity(businessEntity.getBusinessEntityId());
					model.addAttribute("businessEntity", businessEntity);					
					model.addAttribute("searchBEString", request.getParameter("searchBEString"));
					model.addAttribute("associateBusinessEntityId", businessEntity.getPartyId());
					model.addAttribute("assocPerBusEntityId", businessEntity.getPartyId());
					//Set Success Message to be displayed to the user
					List<String> messages = new ArrayList<String>();
					String defaultMessage = MessageUtil.BUSINESS_ENTITY_DEFAULT_MESSAGE;
					//"Your request was successfully processed";
					String message = messageSource.getMessage(MessageUtil.BUSINESSENTITY_SAVE_SUCCESS, null,
							defaultMessage, Locale.US);
					messages.add(message);
					model.addAttribute("messages", messages);
				}
			}
			populateModelWithReferenceTypes(model);
		} catch (AddressBookException e) {
			log.error("AddressBookException caught in BusinessEntityTilesController.saveBusinessEntity : ",e);
			throw e;
		}catch(Exception e){
			log.error("Exception Occured in BusinessEntityTilesController.saveBusinessEntity : ",e);
			throw new AddressBookException(e.getMessage(),e.getCause());
		}
	}

	public void deleteBusinessEntity(BusinessEntity businessEntity, BindingResult result, Model model,
			HttpServletRequest request) throws AddressBookException {
		log.info("Inside BusinessEntityTilesController.deleteBusinessEntity : " + businessEntity);
		String beDeleteComments = null;
		try {
			log.debug("getCommentsToDelete in deleteBusinessEntity--->"+businessEntity.getCommentsToDelete());
			beDeleteComments = businessEntity.getCommentsToDelete();
			businessEntity = businessEntityService.getBusinessEntity(businessEntity.getBusinessEntityId());
			log.debug("businessEntity ===========>"+businessEntity.getApprovalStatus().getApprovalStatus().getId());
			businessEntity.setCommentsToDelete(beDeleteComments);
			controllerUtil.setDTOCommonProperties(businessEntity);
			businessEntityService.deleteBusinessEntity(businessEntity);
			List<String> messages = new ArrayList<String>();
			String defaultMessage = MessageUtil.BUSINESSENTITY_DELETE_MESSAGE ;

			String message = messageSource.getMessage(MessageUtil.BUSINESSENTITY_DELETE_SUCCESS, null,
					defaultMessage, Locale.US);
			messages.add(message);
			model.addAttribute("messages", messages);
			model.addAttribute("businessEntity", new BusinessEntity());
			populateModelWithReferenceTypes(model);
		} catch (AddressBookException e) {
			log.error(
					"AddressBookException caught in BusinessEntityTilesController.deleteBusinessEntity : ",
					e);
			throw e;
		} catch (Exception e) {
			log.error(
					"Exception Occured in BusinessEntityTilesController.deleteBusinessEntity : ",
					e);
			throw new AddressBookException(e.getMessage(), e.getCause());
		}

	}

	@RequestMapping(value = "/tiles_newBusinessEntity")
	public String newBusinessEntity(Model model) throws AddressBookException {
		log.info("Inside BusinessEntityTilesController.newBusinessEntity : ");
		model.addAttribute("businessEntity", new BusinessEntity());
		populateModelWithReferenceTypes(model);
		return "tiles_loadAddressBook";
	}


	@RequestMapping(value = "/tiles_deleteContact")
	public String deleteContact(@RequestParam(value = "contactId") long contactId,
			@RequestParam(value = "businessEntityId") long businessEntityId,
			@RequestParam(value = "commentsToDeleteBEPerson") String comments,
			Model model, HttpServletRequest request) throws AddressBookException{
		log.info("Inside BusinessEntityTilesController.deleteContact "
				+ contactId);
		Contact contact = null;
		try {
			log.debug("commentsToDeleteBEPerson--->"+comments);
			String loggedInUser = controllerUtil.getLoggedInUser();
			contact = new Contact();
			contact.setContactId(contactId);
			contact.setLastUpdatedBy(loggedInUser);
			contact.setLastUpdatedDateTime(new Date());
			contact.setCommentsToDelete(comments);
			businessEntityService.deleteContact(contact);
			List<String> messages = new ArrayList<String>();
			String defaultMessage = MessageUtil.CONTACT_DELETE_MESSAGE;

			String message = messageSource.getMessage(
					MessageUtil.CONTACT_DELETE_SUCCESS, null, defaultMessage,
					Locale.US);
			messages.add(message);
			model.addAttribute("messages", messages);
			BusinessEntity businessEntity = businessEntityService.getBusinessEntity(businessEntityId);
			populateModelWithReferenceTypes(model);
			model.addAttribute("businessEntity", businessEntity);
		} catch (AddressBookException e) {
			log.error("AddressBookException caught in BusinessEntityTilesController.deleteContact : ",e);
			throw e;
		}catch(Exception e){
			log.error("Exception Occured in BusinessEntityTilesController.deleteContact : ",e);
			throw new AddressBookException(e.getMessage(),e.getCause());
		}
		return "tiles_loadAddressBook";
	}*/

  /*	private void populateModelWithReferenceTypes(Model model) throws AddressBookException{
		try{
			model.addAttribute("personPhoneTypes", addressService.getPersonPhoneTypes());
			model.addAttribute("bePhoneTypes", addressService.getBEPhoneTypes());
			model.addAttribute("emailTypes", addressService.getEmailTypes());
		}catch (AddressBookException e) {
			log.error("Exception Occured in BusinessEntityTilesController.populateModelWithReferenceTypes : ",e);

			throw e;
		}
	}*/
	
	
	@RequestMapping(value = "/titlehome")
	public String getBusinessEntity(Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside BusinessEntityTilesController.getBusinessEntity input "
				);
		try {
			/*BusinessEntity businessEntity = businessEntityService.getBusinessEntity(businessEntityId);
			log.debug("Contacts in BE : "+ businessEntity.getContacts());
			//populateModelWithReferenceTypes(model);
			businessEntity.setCommentsToDelete(null);
			businessEntity.setCommentsToUpdate(null);
			model.addAttribute("businessEntity", businessEntity);
			model.addAttribute("searchBEString", request.getParameter("searchBEString"));
			model.addAttribute("selectedBEId", businessEntityId);*/
		} catch(Exception e){
			log.error("Exception Occured in BusinessEntityTilesController.getBusinessEntity : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "tiles_general_layout"; 
	}
	
	
	@RequestMapping(value = "/titlehome2")
	public String getBusinessEntity2(@RequestParam(value = "businessEntityId") long businessEntityId,
			Model model, HttpServletRequest request) throws GTSException{
		log.info("Inside BusinessEntityTilesController.getBusinessEntity input "
				+ businessEntityId);
		try {
			/*BusinessEntity businessEntity = businessEntityService.getBusinessEntity(businessEntityId);
			log.debug("Contacts in BE : "+ businessEntity.getContacts());
			//populateModelWithReferenceTypes(model);
			businessEntity.setCommentsToDelete(null);
			businessEntity.setCommentsToUpdate(null);
			model.addAttribute("businessEntity", businessEntity);
			model.addAttribute("searchBEString", request.getParameter("searchBEString"));
			model.addAttribute("selectedBEId", businessEntityId);*/
		} catch(Exception e){
			log.error("Exception Occured in BusinessEntityTilesController.getBusinessEntity : ",e);
			throw new GTSException(e.getMessage(),e.getCause());
		}
		return "vtitle_tile";
	}
}
