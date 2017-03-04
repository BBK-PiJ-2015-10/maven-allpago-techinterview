package delivery;

import java.util.Scanner;

import usecasesTests.TestManager;

public class InputManager {

	private Scanner scanner;
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	private TestManager testManager;
	
	public InputManager (Scanner scanner){
		this.scanner=scanner;
		//this.deliveryCostEstimator = new DeliveryCostEstimator();
	}
	
	public void processInput(String testIndicator,String delimiter){
		this.deliveryCostEstimator = new DeliveryCostEstimator();
		this.testManager = new TestManager();
		while(scanner.hasNext()){
			String [] sentence = scanner.next().split(delimiter);
			if (!sentence[0].equals(testIndicator)){
				deliveryCostEstimator.feedInput(sentence);
			}
			else {	
				for (int i=0;i<sentence.length;i++){
					System.out.print(sentence[i]);
					System.out.println();
				}
			}
		}
	}
	
	public void startCalculators(){
		deliveryCostEstimator.startCalculators();
	}
	
	public void print(){
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		};
	}
	
	
	public Double getEstimate(String from,String to){
		return deliveryCostEstimator.getEstimate(from,to);
	}
	
	public Double getWeight (Integer width,Integer length,Integer height, Integer weight){
		return deliveryCostEstimator.getWeight(width, length, height, weight);
	}
	
	
	
	
	
	
}
