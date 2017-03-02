package delivery;

import java.util.Scanner;
import java.util.Map;
import java.text.NumberFormat;
import java.util.HashMap;
import java.text.ParseException;
import java.util.Iterator;

public class GraphCreator {
	
	private String testIndicator = "@"; 
	
	private String nodeDelimiter = ",";
	
	private String distanceDelimeter = ":";
	
	private Map<String,Node> nodeMap = new HashMap();
	
	private void createNode(String[] sentence){
		String sourceNodeName = sentence[0];
		if (!nodeMap.containsKey(sourceNodeName)){
			Node<String> sourceNode = new Node(sourceNodeName);
			for (int i=1;i<sentence.length;i++){
				String[] linkData = sentence[i].split(distanceDelimeter);
				String destNodeName = linkData[0];
				Number linkWeight = null;
				
				try {
					linkWeight = NumberFormat.getInstance().parse(linkData[1]);
				} catch (ParseException ex){
					System.out.println("Need to figure out how to handle this");
				}
				
				
			
				Node destNode;
				if (nodeMap.containsKey(destNodeName)){
					destNode=nodeMap.get(destNodeName);
				}
				else {
					destNode = new Node(destNodeName);
				}
				Link<Node,Number> newLink = new Link();
				newLink.setSource(sourceNode);
				newLink.setDestination(destNode);
				newLink.setLength(linkWeight);
				sourceNode.addLink(newLink);
				
			}
			nodeMap.put(sourceNodeName,sourceNode);
		}
	}
	
	public void captureInput(Scanner sc){
		
		while(sc.hasNext()){
			String [] sentence = sc.next().split(nodeDelimiter);
			if (!sentence[0].equals(testIndicator)){
				createNode(sentence);
			}
		}
		
		printGraphTopology();
		
		
	}
	
	public void printGraphTopology(){
		
		for (String value : nodeMap.keySet()){
			System.out.print("Node named : " +value);
			Node tempNode = nodeMap.get(value);
			System.out.println(" has " +tempNode.getLinks().size() +" links");
			System.out.println("which are ");
			Node<String> ok;
			Link<Node,Integer> oktoo;
			Iterator<Link<Node<String>,Integer>> iter = tempNode.getLinks().iterator();
			while(iter.hasNext()){
				
				System.out.println("to " +iter.next().getOther(tempNode).getnodeID());
		
			}
	
		}
		
		System.out.println("I created " +nodeMap.size() +"nodes");
		
	}

}
