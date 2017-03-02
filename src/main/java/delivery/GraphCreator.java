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
		String nodeName = sentence[0];
		if (!nodeMap.containsKey(nodeName)){
			Node newNode = new Node(nodeName);
			nodeMap.put(nodeName,newNode);
		}
	}
	
	public void captureInput(Scanner sc){
		
		while(sc.hasNext()){
			String [] sentence = sc.next().split(nodeDelimiter);
			if (!sentence[0].equals(testIndicator)){
				createNode(sentence);
			}
		}
		
		System.out.println("I created " +nodeMap.size() +"nodes");
		
	}

}
