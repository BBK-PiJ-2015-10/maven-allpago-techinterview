package delivery;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraImpl implements MinDistanceCalculator {
	
	private Map<String,Node<String>> nodeMap = new HashMap<String,Node<String>>();
	
	private Map<Node<String>,Number> pathWeights = new HashMap<Node<String>,Number>();
	
	private PriorityQueue<PrioNode> frontier = new PriorityQueue<PrioNode>(); 

	public DijkstraImpl(Map<String, Node<String>> nodeMap) {
		this.nodeMap = nodeMap;
	}
	
	public Number getMinDistance(String startID, String targetID){
		
		//Setting the distance from the start node to infinity
		nodeMap.values().forEach((n)->pathWeights.put(n,Integer.MAX_VALUE));
		
		//Updating the distance for the start not to 0
		Node startNode = nodeMap.get(startID);
		pathWeights.put(startNode,0);
		
		
		PrioNode startp = new PrioNode(startNode);
		frontier.add(new PrioNode(startNode,0));
		
		while (frontier.size()!=0){
			PrioNode current = frontier.poll();
			Double cWeight =  pathWeights.get(current.getNode()).doubleValue();
			Set<Link> links = current.getNode().getLinks();
			for (Link link : links){
				Node other = ((Node) link.getOther(current.getNode()));
				Double candidateWeight = cWeight+link.getWeight().doubleValue();
				Double existingWeight = pathWeights.get(other).doubleValue();
				if (existingWeight==Integer.MAX_VALUE){
					pathWeights.put(other,candidateWeight);
					frontier.add(new PrioNode(other,candidateWeight));
	
				}
				else if (candidateWeight<existingWeight){
					pathWeights.put(other,candidateWeight);
					PrioNode temp = new PrioNode(other);
					frontier.remove(temp);
					temp.setPriority(candidateWeight);
					frontier.add(temp);
				}
			}
			
		}
		
		//System.out.println(pathWeights.get(nodeMap.get(targetID)).doubleValue());
		
		return pathWeights.get(nodeMap.get(targetID)).doubleValue();
		
	}
	
	
	

}
