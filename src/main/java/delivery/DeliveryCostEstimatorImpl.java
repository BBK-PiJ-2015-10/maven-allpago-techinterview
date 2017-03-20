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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YasserAlejandro
 * 
 * A class implementing the DeliveryCostEstimator interface. Internally it leverages
 * a GraphCreator, a MinDistanceCalc, a VolumetricWeightCalc, and 
 * NormalizedWeightCalc objects.
 */
@Component("estimator")
public class DeliveryCostEstimatorImpl implements DeliveryCostEstimator {
	
	@Autowired
	private GraphCreator graphCreator;
	
	@Autowired
	private MinDistanceCalc minDistanceCalculator;
	
	//private VolumetricWeightCalc volumetricWeightCalc;
	
	@Autowired
	private NormalizedWeightCalc normalizedWeightCalc;
	
	public DeliveryCostEstimatorImpl(){
		//graphCreator = new GraphCreatorImpl();
		//graphCreator.setDistanceDelimeter(":");
	}
	
	/**
	 * Implement method from interface
	 * @see delivery.DeliveryCostEstimator#startCalculators()
	 */
	@Override
	public void startCalculators(){
		//minDistanceCalculator = new MinDistanceCalcDijkstraImpl(graphCreator.getGraph());
		minDistanceCalculator.setGraph(graphCreator.getGraph());
		//volumetricWeightCalc = new VolumetricWeightCalcImpl();
		//normalizedWeightCalc = (NormalizedWeightCalc)DeliveryFactory.getBeanFactory().getBean("weightcalc");
		//normalizedWeightCalc = new NormalizedWeightCalcImpl(volumetricWeightCalc);
	}
	
	//Provides shipping cost estimate
	private Double getRealEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		Integer notConnected = Integer.MAX_VALUE;
		if(notConnected.doubleValue()==getMinDistanceEstimate(from,to)){
			return -1.0;
		}
		return Math.sqrt(getMinDistanceEstimate(from,to))*getWeight(width,length,height,weight);
	
	}
	
	//Retrieves the minimum distance from point from to point to.
	private Double getMinDistanceEstimate(String from, String to){	
		return minDistanceCalculator.getMinDistance(from,to).doubleValue();
	}
	
	//Retrieves the normalized weight of the item.
	private Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		return normalizedWeightCalc.calculateNormalizedWeight(width, length, height, weight);
	}
	
	/**
	 * Implements method from interface
	 * @see delivery.DeliveryCostEstimator#getEstimate(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
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
	
	/**
	 * Implements method from interface
	 * @see delivery.DeliveryCostEstimator#feedInput(java.lang.String[])
	 */
	@Override
	public void feedInput(String [] sentence){
		graphCreator.feedGraph(sentence);
	}
	
	
	

}
