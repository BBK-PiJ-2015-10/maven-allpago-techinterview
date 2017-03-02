package delivery;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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
				sourceNode.addLink(newLink);
				//System.out.println("The label is " +linkData[0]);
				//System.out.println("The cost is " +linkData[1]);
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
				
		for (String value : nodeMap.keySet()){
			System.out.print("Node named : " +value);
			System.out.println(" has " +nodeMap.get(value).getLinks().size() +" links");
			
		}
		
		System.out.println("I created " +nodeMap.size() +"nodes");
		
	}

}
