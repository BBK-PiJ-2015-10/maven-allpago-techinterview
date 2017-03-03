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

	public void launchEstimates(){
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
		Double estWeight = normalizedWeightCalc.calculateVolWeight(width, length, height, weight);
		Double estDistance = minDistanceCalculator.getMinDistance(from,to).doubleValue();
		return estWeight*estDistance;
	}
	
	
	
	
	
	

}
