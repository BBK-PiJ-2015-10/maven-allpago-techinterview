package delivery.graph;

import java.util.Map;

/**
 * @author YasserAlejandro
 *
 * A class implementing the GraphCreator interface needs to create a Graph
 * to represent the Node and Links(Edges) in the graph.
 */
public interface GraphCreator {
	
	/**
	 * Provides input to populate the graph
	 * @param sentence representing the String array with the information of each individual
	 * Node at a time. First String contains the lead Node Element, subsequent Strings contains
	 * the link information for that node.
	 */
	void feedGraph(String[] sentence);
	
	/**
	 * Provides access to the graph built
	 * @return the graph object built based on the input.
	 */
	Map<String,Node<String>> getGraph();
	
	/**
	 * Sets the String delimeter to use to separate the distance or weight data contains
	 * in the String carrying that information.
	 * @param distanceDelimeter
	 */
	void setDistanceDelimeter(String distanceDelimeter);
	

}
