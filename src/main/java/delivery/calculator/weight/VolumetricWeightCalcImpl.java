package delivery.calculator.weight;

import java.lang.Math.*;

/**
 * @author YasserAlejandro
 * 
 * A class that implements the VolumetricWeightCalc interface.
 */
public class VolumetricWeightCalcImpl implements VolumetricWeightCalc {
		
	private Double rawWeight;
	
	@Override
	public Double calculateVolWeight(Integer width, Integer length, Integer height,Double AdjFactor) {
		rawWeight=width*length*height/AdjFactor;
		Double root = (Math.floor(rawWeight/.5))*.5;
		Double bal;
		Double diff=rawWeight-root;
		if(diff.equals(0.00000)){
			bal=0.0;
		}
		else {
			bal=0.5;
		}
		return (root+bal);
	}
	

	
	
	
	
	
}
