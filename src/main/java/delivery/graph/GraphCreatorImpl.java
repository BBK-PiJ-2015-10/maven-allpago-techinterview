package delivery.graph;

import java.util.Map;
import java.text.NumberFormat;
import java.util.HashMap;
import java.text.ParseException;

import delivery.unit.Hard;

/**
 * 
 * @author YasserAlejandro
 *
 * An implementation of the GraphCreator interface. Utilizing class Node<String> as Nodes 
 * and class Link<Node<String>,Hard<Number>> as Links. It assumes weight or distance
 * information. 
 */
public class GraphCreatorImpl implements GraphCreator {
	
	//This field host the String used to delimeter the distance or weight between nodes
	private String distanceDelimeter = ":";
	
	//A map holding all the unique Nodes in the graph.
	private Map<String,Node<String>> nodeMap = new HashMap<String,Node<String>>();
	
	public Map<String,Node<String>> getGraph(){
		return this.nodeMap;
	}
	
	/**
	 * @see delivery.graph.GraphCreator#setDistanceDelimeter(java.lang.String)
	 */
	@Override
	public void setDistanceDelimeter(String distanceDelimeter) {
		this.distanceDelimeter=distanceDelimeter;
	}
	
	/**
	 * @see delivery.graph.GraphCreator#feedGraph(java.lang.String[])
	 */
	public void feedGraph(String[] sentence){
		createNodeandLinks(sentence);
	}
	
	/*
	 * Based on a String[] input it adds Node and its links into the graph
	 */
	private void createNodeandLinks(String[] sentence){
		String sourceNodeName = sentence[0];
		Node<String> sourceNode;
		if (!nodeMap.containsKey(sourceNodeName)){
			sourceNode = new Node<String>(sourceNodeName);
		}
		else {
			sourceNode = nodeMap.get(sourceNodeName);
		}
			
		for (int i=1;i<sentence.length;i++){
			String[] linkData = sentence[i].split(distanceDelimeter);
			String destNodeName = linkData[0];
			Hard<Number> linkWeight = null;
			try {
				linkWeight = new Hard(NumberFormat.getInstance().parse(linkData[1]));
			} catch (ParseException ex){
				System.out.println("The argument entered is not a number");
			}
			Node<String> destNode;
			if (nodeMap.containsKey(destNodeName)){
				destNode=nodeMap.get(destNodeName);
			}
			else {
				destNode = new Node<String>(destNodeName);
				nodeMap.put(destNodeName,destNode);
			}
			Link<Node<String>,Hard<Number>> newLink = new Link<Node<String>,Hard<Number>>();
			newLink.setSource(sourceNode);
			newLink.setDestination(destNode);
			newLink.setLength(linkWeight);
			sourceNode.addLink(newLink);
		}
		
		nodeMap.put(sourceNodeName,sourceNode);
	
	}

	
	
	
	


}
