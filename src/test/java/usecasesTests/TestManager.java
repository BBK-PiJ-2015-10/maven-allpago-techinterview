package usecasesTests;

import delivery.DeliveryCostEstimator;

public class TestManager {
	
	private String dimDelimiter ="x";
	
	public int getDimension(String sentence,int pos){
		String [] dimensions = sentence.split(dimDelimiter);
		return Integer.parseInt(dimensions[pos]);
	}
	
	public boolean evaluate(String [] sentence,DeliveryCostEstimator deliveryCostEstimator){
		deliveryCostEstimator.getEstimate("ME",sentence[1],getDimension(sentence[2],0),getDimension(sentence[2],1),
				getDimension(sentence[2],2),getDimension(sentence[2],3));		
		return true;
	}
	
	
	

}
