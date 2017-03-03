package delivery;

import java.util.Map;
import java.util.Scanner;

public interface GraphCreator {
	
	void createGraph(Scanner sc);
	
	Map<String,Node<String>> getGraph();

}
