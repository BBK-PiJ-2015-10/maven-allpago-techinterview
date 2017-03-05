package delivery;

//import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.lang.Math;

public class DeliveryCostEstimator {
	
	private GraphCreator graphCreator;
	
	private MinDistanceCalculator minDistanceCalculator;
	
	private VolumetricWeightCalc volumetricWeightCalc;
	
	private NormalizedWeightCalc normalizedWeightCalc;
	
	//private Scanner sc;
	
	/*
	public DeliveryCostEstimator(Scanner sc){
		this.sc=sc;
	}
	*/
	
	public DeliveryCostEstimator(){
		graphCreator = new GraphCreatorImpl();
	}

	/*
	public void launchEstimator(){
		loadEstimator();
	}
	*/
	
	public void startCalculators(){
		minDistanceCalculator = new DijkstraImpl(graphCreator.getGraph());
		volumetricWeightCalc = new VolumetricWeightCalcImpl();
		normalizedWeightCalc = new NormalizedWeightCalcImpl(volumetricWeightCalc);
	}
	
	private void loadEstimator(){
		//graphCreator = new GraphCreatorImpl();
		//graphCreator.createGraph(sc);
		//minDistanceCalculator = new DijkstraImpl(graphCreator.getGraph());
		//volumetricWeightCalc = new VolumetricWeightCalcImpl();
		//normalizedWeightCalc = new NormalizedWeightCalcImpl(volumetricWeightCalc);
	}
	
	public Double getRealEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		Integer notConnected = Integer.MAX_VALUE;
		if(notConnected.doubleValue()==getEstimate(from,to)){
			return -1.0;
		}
		System.out.println("The distance is "+getEstimate(from,to));
		return Math.sqrt(getEstimate(from,to))*getWeight(width,length,height,weight);
	}
	

	public Double getEstimate(String from, String to){
		//System.out.println("Distance is " +minDistanceCalculator.getMinDistance(from,to).doubleValue());
		return minDistanceCalculator.getMinDistance(from,to).doubleValue();
	}
	
	public Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		System.out.println("Weight is " +normalizedWeightCalc.calculateVolWeight(width, length, height, weight));
		return normalizedWeightCalc.calculateVolWeight(width, length, height, weight);
	}
	
	public String getEstimate(String from, String to,Integer width,Integer length,Integer height, Integer weight){
		try {
			Double estimate = getRealEstimate(from,to,width,length,height,weight);
			if (estimate==-1.0){
				return "~";
			}
			DecimalFormat df = new DecimalFormat("#.##");
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
