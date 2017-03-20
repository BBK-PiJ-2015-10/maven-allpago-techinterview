package delivery.calculator.distance;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import delivery.graph.Link;
import delivery.graph.Node;
import delivery.graph.PrioNode;

import delivery.unit.Hard;

import org.springframework.stereotype.Component;

/**
 * @author YasserAlejandro
 * 
 * An implementation of the MinDistanceCalc interface. It leverages a Map to
 * keep track of the distance calculations between the starting node and each
 * node of the graph. A priority queue is utilized the facilitate the navigation
 * within graph and achieve the Dijkstra algorithm logic.
 */
@Component
public class MinDistanceCalcDijkstraImpl implements MinDistanceCalc {
	
	private Map<String,Node<String>> nodeMap = new HashMap<String,Node<String>>();
	
	private Map<Node<String>,Hard<Number>> pathWeights = new HashMap<Node<String>,Hard<Number>>();
	
	private PriorityQueue<PrioNode> frontier = new PriorityQueue<PrioNode>(); 
	
	
	/**
	 * Constructor
	 * @param nodeMap a Map that captures all the Nodes and Links within the graph
	 */
	//public MinDistanceCalcDijkstraImpl(Map<String, Node<String>> nodeMap) {
		//this.nodeMap = nodeMap;
	//}
	
	public void setGraph(Map<String,Node<String>> nodeMap){
		this.nodeMap=nodeMap;
	}
	
	
	/**
	 * Provides the minimum distance between two node IDs.
	 * 
	 */
	public Number getMinDistance(String startID, String targetID){
		
		//Setting the distance from the start node to infinity
		nodeMap.values().forEach((n)->pathWeights.put(n,new Hard(Integer.MAX_VALUE)));
		
		//Updating the distance for the start not to 0
		Node startNode = nodeMap.get(startID);
		pathWeights.put(startNode,new Hard(0));
		
		//Creates a PrioNode to enable the priority implementation of the PriorityQueue
		PrioNode startp = new PrioNode(startNode);
		frontier.add(new PrioNode(startNode,0));
		
		while (frontier.size()!=0){
			PrioNode current = frontier.poll();
			Double cWeight =  pathWeights.get(current.getNode()).getHardUnit().doubleValue();
			Set<Link> links = current.getNode().getLinks();
			for (Link link : links){
				Node other = ((Node) link.getOther(current.getNode()));
				Double candidateWeight = cWeight+link.getWeight().getHardUnit().doubleValue();
				Double existingWeight = pathWeights.get(other).getHardUnit().doubleValue();
				if (existingWeight==Integer.MAX_VALUE){
					pathWeights.put(other,new Hard(candidateWeight));
					frontier.add(new PrioNode(other,candidateWeight));
				}
				else if (candidateWeight<existingWeight){
					pathWeights.put(other,new Hard(candidateWeight));
					PrioNode temp = new PrioNode(other);
					frontier.remove(temp);
					temp.setPriority(candidateWeight);
					frontier.add(temp);
				}
			}
			
		}
		
		return pathWeights.get(nodeMap.get(targetID)).getHardUnit().doubleValue();
		
	}
	
	
	

}
