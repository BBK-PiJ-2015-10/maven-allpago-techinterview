package delivery;


import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.Math;

public class DeliveryCostEstimator {
	
	private GraphCreator graphCreator;
	
	private MinDistanceCalculator minDistanceCalculator;
	
	private VolumetricWeightCalc volumetricWeightCalc;
	
	private NormalizedWeightCalc normalizedWeightCalc;
	

	public DeliveryCostEstimator(){
		graphCreator = new GraphCreatorImpl();
	}

	public void startCalculators(){
		minDistanceCalculator = new DijkstraImpl(graphCreator.getGraph());
		volumetricWeightCalc = new VolumetricWeightCalcImpl();
		normalizedWeightCalc = new NormalizedWeightCalcImpl(volumetricWeightCalc);
	}
	
	
	private Double getRealEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		Integer notConnected = Integer.MAX_VALUE;
		if(notConnected.doubleValue()==getMinDistanceEstimate(from,to)){
			return -1.0;
		}
		return Math.sqrt(getMinDistanceEstimate(from,to))*getWeight(width,length,height,weight);
	}
	

	private Double getMinDistanceEstimate(String from, String to){
		return minDistanceCalculator.getMinDistance(from,to).doubleValue();
	}
	
	private Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		return normalizedWeightCalc.calculateVolWeight(width, length, height, weight);
	}
	
	public String getEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		try {
			Double estimate = getRealEstimate(from,to,width,length,height,weight);
			if (estimate==-1.0){
				return "~";
			}
			DecimalFormat df = new DecimalFormat("#.00");
			df.setRoundingMode(RoundingMode.HALF_EVEN);
		    return df.format(estimate);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return "An exception has ocurred";
	}
	
	public void feedInput(String [] sentence){
		graphCreator.feedGraph(sentence);
	}
	
	
	

}
