package delivery.graph;

import java.util.Map;
import java.text.NumberFormat;
import java.util.HashMap;
import java.text.ParseException;
import java.util.Iterator;

import delivery.unit.Hard;


public class GraphCreatorImpl implements GraphCreator {
		
	private String distanceDelimeter = ":";
	
	private Map<String,Node<String>> nodeMap = new HashMap<String,Node<String>>();
	
	public Map<String,Node<String>> getGraph(){
		return this.nodeMap;
	}
	
	public void feedGraph(String[] sentence){
		createNodeandLinks(sentence);
	}
	
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
			//Number linkWeight = null;
			try {
				//linkWeight = NumberFormat.getInstance().parse(linkData[1]);
				linkWeight = new Hard(NumberFormat.getInstance().parse(linkData[1]));
			} catch (ParseException ex){
				System.out.println("Need to figure out how to handle this");
			}
			Node<String> destNode;
			if (nodeMap.containsKey(destNodeName)){
				destNode=nodeMap.get(destNodeName);
			}
			else {
				destNode = new Node<String>(destNodeName);
				nodeMap.put(destNodeName,destNode);
			}
			//Link<Node<String>,Number> newLink = new Link<Node<String>,Number>();
			Link<Node<String>,Hard<Number>> newLink = new Link<Node<String>,Hard<Number>>();
			newLink.setSource(sourceNode);
			newLink.setDestination(destNode);
			newLink.setLength(linkWeight);
			sourceNode.addLink(newLink);
		}
		
		nodeMap.put(sourceNodeName,sourceNode);
	
	}
	
	public void printGraphTopology(){
		for (String value : nodeMap.keySet()){
			System.out.print("Node named : " +value);
			Node tempNode = nodeMap.get(value);
			System.out.println(" has " +tempNode.getLinks().size() +" links");
			System.out.println("which are ");
			//Iterator<Link<Node<String>,Integer>> iter = tempNode.getLinks().iterator();
			Iterator<Link<Node<String>,Hard<Integer>>> iter = tempNode.getLinks().iterator();
			
			while(iter.hasNext()){
				//Link<Node<String>,Integer> temp = iter.next();
				Link<Node<String>,Hard<Integer>> temp = iter.next();
				System.out.print("with a weight of " +temp.getWeight());
				System.out.println(" to " +temp.getOther(tempNode).getnodeID());
			}
		}
	}
	


}
