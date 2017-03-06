package delivery.calculator.weight;

/**
 * @author Alejandro
 * 
 * A class implementing the NormalizedWeightCalc needs to provide the Normalized Weight of an object.
 * The normalized weight is the larger of the volumetric weight of an object and its actual weight.
 */

public interface NormalizedWeightCalc {
	
	/**
	 * @param width of the item in centimeters.
	 * @param length of the item in centimeter.
	 * @param height of the item in centimeter.
	 * @param weight of the item in grams.
	 * @return a Double representing the normalized weight of an item.
	 */
	public Double calculateNormalizedWeight(Integer width,Integer length, Integer height,Integer weight);
	

}
