package usecasesTests;

import delivery.DeliveryCostEstimator;

public class TestManager {
	
	public boolean evaluate(String [] sentence,DeliveryCostEstimator deliveryCostEstimator){
		deliveryCostEstimator.getEstimate("ME","GOD", 10,11,12,13);		
		return true;
	}
	
	
	

}
