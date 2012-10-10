import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ffe.common.exception.GTSException;
import com.ffe.title.model.Title;
import com.ffe.title.service.TitleService;


public class TestDriver {
	public static void main(String[] args) {
		Title();
	}

	private static void Title() {
		String myBeanResources[] = new String[] { "spring-app-context.xml"};
//		System.setProperty("CONFIG_PATH", "../addressbook-services/config");
//		System.setProperty("LOG_PATH", "C://log");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
		TitleService titleService = (TitleService) ctx.getBean("titleService");
		Title entity = new Title();
		entity.setWprNumber("asfa32e");
		entity.setTitleName("jurrassic park");
		entity.setHh(100l);
		entity.setMm(100l);
		entity.setSs(100l);
	
		String releaseyear="2001";
		entity.setReleaseyear(releaseyear);
		try {
			titleService.saveTitle(entity);
		} catch (GTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("title id "+ entity);
		/* test for association of address to a party " 
		//List<Person> list= userInforamtion.searchPerson("ra");
		PartyAddress addressPhysicalAssoc = new PartyAddress();
		com.nbcu.addressbook.core.model.BusinessEntity businessEntity= new com.nbcu.addressbook.core.model.BusinessEntity();
		businessEntity.setPartyId(409l);
		addressPhysicalAssoc.setParty(businessEntity);
		com.nbcu.addressbook.core.model.Address address= new com.nbcu.addressbook.core.model.Address();
		address.setAddressId(142l);
		addressPhysicalAssoc.setAddress(address);
		
		com.nbcu.addressbook.core.model.ReferenceType addressRoleType= new com.nbcu.addressbook.core.model.ReferenceType();
		addressRoleType.setId(1l);
		addressPhysicalAssoc.setAddressRole(addressRoleType);
		*/
		
		
	}
}
