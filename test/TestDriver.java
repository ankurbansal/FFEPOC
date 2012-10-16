import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ffe.common.exception.GTSException;
import com.ffe.service.model.DigitalCostsVendor;
import com.ffe.service.model.DigitalServTemplate;
import com.ffe.service.model.DigitalService;
import com.ffe.service.service.DigitalCostService;
import com.ffe.title.model.Title;
import com.ffe.title.service.TitleService;


public class TestDriver {
	public static void main(String[] args) {
		vendor();
	}
	
	
	private static void titleCode(){
		String myBeanResources[] = new String[] { "spring-app-context.xml"};
		System.setProperty("LOG_PATH", "C://log");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
		
		TitleService titleService = (TitleService) ctx.getBean("titleService");
		try {
			System.out.println(titleService.getTitle(21l));
		} catch (GTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	

	private static void vendor() {
		String myBeanResources[] = new String[] { "spring-app-context.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
	
		//Digital Cost test
		
		DigitalCostService digiCostService = (DigitalCostService)ctx.getBean("digitalcostservice");
		try
		{
		/*List<DigitalService> serviceLst = digiCostService.lstAllService();
		for(DigitalService digiServ:serviceLst)
		{
			System.out.println(digiServ.getDigiServName());
		}*/
		
			/*DigitalService digitalServiceop = digiCostService.getService(1L);
			System.out.println(digitalServiceop.getDigiServName());*/
			
			/*List<DigitalCostsVendor> serviceLst = digiCostService.lstAllVendors();
			for(DigitalCostsVendor digiServ:serviceLst)
			{
				System.out.println(digiServ.getVendorName());
			}*/
			
			/*DigitalCostsVendor digitalServiceop = digiCostService.getVendor(2L);
			System.out.println(digitalServiceop.getVendorName());*/
			
			/*List<DigitalServTemplate> serviceLst = digiCostService.lstAllServiceTemplate();
			for(DigitalServTemplate digiServ:serviceLst)
			{
				System.out.println(digiServ.getDigiServTempName());
			} */
			
			/*DigitalServTemplate digitalServiceop = digiCostService.getServiceTemplate(4L);
			System.out.println(digitalServiceop.getDigiServTempName());*/
			
			/*List<DigitalService> serviceLst = digiCostService.lstServicebyTemplate(1L);
			for(DigitalService digiServ:serviceLst)
			{
				System.out.println(digiServ.getDigiServName());
				System.out.println();
			}*/
			/*List<DigitalServTemplate> serviceLst = digiCostService.lstServiceTemplateByCostType("Digital Feature");
			for(DigitalServTemplate digiServ:serviceLst)
			{
				System.out.println(digiServ.getDigiServTempName());
			}*/
			
			/*List<DigitalCostsVendor> serviceLst = digiCostService.lstVendorBasedonService("Talent_Fee","3");
			for(DigitalCostsVendor vend:serviceLst)
			{
				System.out.println(vend.getVendorName());
			}*/
			
			//Get Rate Card for Service
			
			/*int rate_card = digiCostService.getRateCardforServicebasedonVendor("Talent_Fee","3",1);
			System.out.println("RateCard\t"+rate_card);*/
			
			//List Service based on CostType
			List<DigitalService> serviceLst = digiCostService.lstServiceByCostType(3);
			for(DigitalService digiServ:serviceLst)
			{
				System.out.println(digiServ.getDigiServName());
				
			}
			
		}
		catch(GTSException gts)
		{
			gts.printStackTrace();
			System.out.println("GTS Exception");
			System.out.println(gts.getLocalizedMessage());
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
			System.out.println("Other Exception");
		}
		
	}
}
