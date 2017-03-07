package delivery.calculator.weight;

/** 
 * @author YasserAlejandro
 * 
 * A class implementing the VolumetricWeightCalc interface needs to provide the volumetric
 * weight equivalent of an object based on its volume.
 */
public interface VolumetricWeightCalc {
	
	/**
	 * Returns the volu-metric weight of an object.
	 * @param width of the object.
	 * @param length of the object.
	 * @param height of the object.
	 * @param adjFactor represents the adjustment factor to be used to calculate the volumetric weight.
	 * @return a Double representing the volumetric weight of an object.
	 */
	public Double calculateVolWeight(Integer width,Integer length, Integer height,Double adjFactor);
	

}
