package delivery;


import java.text.DecimalFormat;

import delivery.calculator.distance.MinDistanceCalcDijkstraImpl;
import delivery.calculator.distance.MinDistanceCalc;
import delivery.calculator.weight.NormalizedWeightCalc;
import delivery.calculator.weight.NormalizedWeightCalcImpl;
import delivery.calculator.weight.VolumetricWeightCalc;
import delivery.calculator.weight.VolumetricWeightCalcImpl;
import delivery.graph.GraphCreator;
import delivery.graph.GraphCreatorImpl;

import java.math.RoundingMode;
import java.lang.Math;

public class DeliveryCostEstimator {
	
	private GraphCreator graphCreator;
	
	private MinDistanceCalc minDistanceCalculator;
	
	private VolumetricWeightCalc volumetricWeightCalc;
	
	private NormalizedWeightCalc normalizedWeightCalc;
	

	public DeliveryCostEstimator(){
		graphCreator = new GraphCreatorImpl();
	}

	public void startCalculators(){
		minDistanceCalculator = new MinDistanceCalcDijkstraImpl(graphCreator.getGraph());
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
	
	private Long getMinDistanceEstimate(String from, String to){	
		return minDistanceCalculator.getMinDistance(from,to).longValue();
	}
	
	private Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		return normalizedWeightCalc.calculateNormalizedWeight(width, length, height, weight);
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
		return "An exception has ocurred. Please review your input data.";
	}
	
	public void feedInput(String [] sentence){
		graphCreator.feedGraph(sentence);
	}
	
	
	

}
