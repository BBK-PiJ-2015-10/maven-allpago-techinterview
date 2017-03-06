package delivery.calculator.distance;

/**
 * @author Alejandro
 * 
 * A class that implements MinDistanceCalc provides the minimal distance between
 * two points in a graph.
 */
public interface MinDistanceCalc {
	
	/**
	 * @param startID representing the starting node
	 * @param targetID representing the node to be reached
	 * @return the minimum distance between the starting node and the
	 * target node
	 */
	Number getMinDistance(String startID, String targetID);
	
}
