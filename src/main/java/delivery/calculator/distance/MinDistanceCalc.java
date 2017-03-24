package delivery.calculator.distance;

import java.util.Map;

import delivery.graph.Node;

/**
 * @author YasserAlejandro
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
	
	/**
	 * Sets the graph inside the Calculator.
	 * @param nodeMap representing the graph.
	 */
	void setGraph(Map<String,Node<String>> nodeMap);
	
}
