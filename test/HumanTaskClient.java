import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.model.Estimate;
import com.ffe.estimate.service.EstimateService;


public class HumanTaskClient {
public static void main(String[] args) {
	String myBeanResources[] = new String[] { "spring-app-context.xml","spring-jbpm-context.xml"};
	ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
	EstimateService estimateService = (EstimateService)ctx.getBean("estimateService");
	
	try {
		estimateService.claimEstimateTask(7l,"abu");
		/*Estimate est = estimateService.getEstimate(16l);
		estimateService.rejectEstimate(6l, "abu", est);*/
	} catch (GTSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
