import java.util.List;

import org.jbpm.task.query.TaskSummary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ffe.common.exception.GTSException;
import com.ffe.estimate.service.EstimateService;
import com.ffe.process.task.model.EstimateTaskSummary;


public class ShowTask {
public static void main(String[] args) {
	String myBeanResources[] = new String[] { "spring-app-context.xml","spring-jbpm-context.xml"};
	ApplicationContext ctx = new ClassPathXmlApplicationContext(myBeanResources);
	EstimateService estimateService = (EstimateService)ctx.getBean("estimateService");
	try {
		List<EstimateTaskSummary> lst  = estimateService.lstEstimateTaskAssginedtoGroup("Region","en-UK");
		for(EstimateTaskSummary sum:lst){
			System.out.println(sum.getTaskSummary().getId());
			System.out.println(sum.getTaskSummary().getName());
			
			System.out.println(sum.getEstimate().getEstCostStaId());
			System.out.println(sum.getEstimate().getEstimateId());
			
			
		}
	} catch (GTSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
