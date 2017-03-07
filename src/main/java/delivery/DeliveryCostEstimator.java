package delivery;

/**
 * 
 * @author YasserAlejandro
 *
 * A class implementing the DeliveryCostEstimator interface needs to provide an estimate of the
 * cost for shipping an item from one point to another point.
 */
public interface DeliveryCostEstimator {
	
	/**
	 * Provides a method for data input.
	 * 
	 * @param sentence . First String contains the lead Node Element, subsequent Strings contains
	 * the link information for that node.
	 */
	public void feedInput(String [] sentence);
	
	/**
	 * Starts the internal calculators being used. Method should be executed once input has been fed.
	 */
	public void startCalculators();
	
	/**
	 * Provides a cost estimate for shipping an item.
	 * @param from indicating the source point.
	 * @param to indicating the destination point.
	 * @param width indicating the width of the item being sent.
	 * @param length indicating the length of the item being sent.
	 * @param height indicating the height of the item being sent.
	 * @param weight indicating the weight of the item being sent.
	 * @return a String with the information on the shipping cost. If point is not reachable
	 * it will return ~, if an exception occurs it will print stackTrace and return a message.
	 */
	public String getEstimate(String from, String to,Integer width,
			Integer length,Integer height, Integer weight);

}
