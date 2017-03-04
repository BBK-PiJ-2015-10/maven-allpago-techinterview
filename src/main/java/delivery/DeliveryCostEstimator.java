package delivery;

import java.util.Scanner;

public class DeliveryCostEstimator {
	
	private GraphCreator graphCreator;
	
	private MinDistanceCalculator minDistanceCalculator;
	
	private VolumetricWeightCalc volumetricWeightCalc;
	
	private NormalizedWeightCalc normalizedWeightCalc;
	
	private Scanner sc;
	
	public DeliveryCostEstimator(Scanner sc){
		this.sc=sc;
	}

	public void launchEstimator(){
		loadEstimator();
	}
	
	private void loadEstimator(){
		graphCreator = new GraphCreatorImpl();
		graphCreator.createGraph(sc);
		minDistanceCalculator = new DijkstraImpl(graphCreator.getGraph());
		volumetricWeightCalc = new VolumetricWeightCalcImpl();
		normalizedWeightCalc = new NormalizedWeightCalcImpl(volumetricWeightCalc);
	}
	
	public Double getEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		Integer notConnected = Integer.MAX_VALUE;
		if(notConnected.doubleValue()==getEstimate(from,to)){
			return -1.0;
		}
		return getEstimate(from,to)*getWeight(width,length,height,weight);
	}
	

	public Double getEstimate(String from, String to){
		return minDistanceCalculator.getMinDistance(from,to).doubleValue();
	}
	
	public Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		return normalizedWeightCalc.calculateVolWeight(width, length, height, weight);
	}
	
	
	
	
	

}
