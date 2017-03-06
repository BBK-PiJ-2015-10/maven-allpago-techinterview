package delivery.calculator.weight;

import java.lang.Math.*;

public class VolumetricWeightCalcImpl implements VolumetricWeightCalc {
		
	private Double rawWeight;
	
	private Double volWeight;
	
	@Override
	public Double calculateVolWeight(Integer width, Integer length, Integer height) {
		this.rawWeight=width*length*height/5000.0;
		Double root = (Math.floor(rawWeight/.5))*.5;
		Double bal;
		Double diff=this.rawWeight-root;
		if(diff.equals(0.00000)){
			bal=0.0;
		}
		else {
			bal=0.5;
		}
		return this.volWeight=root+bal;
	}
	
	
	
	
	
}
