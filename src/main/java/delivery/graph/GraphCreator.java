package delivery.graph;

import java.util.Map;
import java.util.Scanner;

public interface GraphCreator {
	
	//void createGraph(Scanner sc);
	
	void feedGraph(String[] sentence);
	
	Map<String,Node<String>> getGraph();

}
