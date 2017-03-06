package delivery.graph;

import java.util.Map;

/**
 * 
 * @author YasserAlejandro
 *
 * A class implementing the GraphCreator interface needs to create a Graph
 * to represent the Node and Links(Edges) in the graph.
 */
public interface GraphCreator {
	
	/**
	 * Provides input to populate the graph
	 * @param sentence representing the String array with the information of each individual
	 * Node at a time.
	 */
	void feedGraph(String[] sentence);
	
	/**
	 * Provides access to the graph built
	 * @return the graph object buildt based on the input.
	 */
	Map<String,Node<String>> getGraph();

}
