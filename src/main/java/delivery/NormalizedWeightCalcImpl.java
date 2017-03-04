package delivery;

public class NormalizedWeightCalcImpl implements NormalizedWeightCalc {

	private VolumetricWeightCalc volumetricWeightcalc;
	
	public NormalizedWeightCalcImpl(VolumetricWeightCalc volumetricWeightcalc) {
		this.volumetricWeightcalc = volumetricWeightcalc;
	}

	@Override
	public Double calculateVolWeight(Integer width, Integer length, Integer height, Integer weight) {
		Double realWeight = weight.doubleValue();
		Double volWeight = volumetricWeightcalc.calculateVolWeight(width, length, height);
		if (volWeight>realWeight){
			return volWeight;
		}	
		return realWeight;
	}
		



	
	
}