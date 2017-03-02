package delivery;

import java.util.Scanner;

public class GraphCreator {
	
	public void captureInput(Scanner sc){
		
		while(sc.hasNext()){
			String sentence = sc.next();
			System.out.println(sentence.substring(0,1));
			System.out.println(sc.next());
		}
		
	}

}
