package delivery.calculator.weight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YasserAlejandro
 * 
 * An implementation of the NormalizedWeightCalc interface. It leverages a 
 * volumetric weight calculator as a helper.
 */
@Component("weightcalc")
public class NormalizedWeightCalcImpl implements NormalizedWeightCalc {

	@Autowired
	private VolumetricWeightCalc volumetricWeightcalc = null;
		
	/**
	 * Implements method from interface.
	 */
	@Override
	public Double calculateNormalizedWeight(Integer width, Integer length, Integer height, Integer weight) {
		Double realWeight = weight.doubleValue()/1000;
		Double volWeight = volumetricWeightcalc.calculateVolWeight(width, length, height,5000.0);
		if (volWeight>realWeight){
			return volWeight;
		}	
		return realWeight;
	}
	
	



	
	
}
