package delivery.calculator.weight;

import java.lang.Math.*;

public class VolumetricWeightCalcImpl implements VolumetricWeightCalc {
		
	private Double rawWeight;
	
	private Double volWeight;
	
	@Override
	public Double calculateVolWeight(Integer width, Integer length, Integer height) {
		this.rawWeight=width*length*height/5000.0;
		Double root = (Math.floor(rawWeight/.5))*.5;
		Double bal =0.0;
		if(rawWeight-root>0);{
			bal=.5;
		}
		return this.volWeight=root+bal;
	}
	
	private void initFields (Integer width, Integer length, Integer height) {
		this.rawWeight=width*length*height/5000.0;
		
		Double root = (Math.floor(rawWeight/.5))*.5;
		Double bal =0.0;
		if(rawWeight-root>0);{
			bal=.5;
		}
		this.volWeight=root+bal;
	
		System.out.println(volWeight);
		
		
	}
	
	
	
}
