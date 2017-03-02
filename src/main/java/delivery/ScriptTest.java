package delivery;

import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScriptTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String dirAddress = "C:\\Users\\YasserAlejandro\\Dropbox\\JobSearch\\InterviewPrep\\Allpago\\test\\03.csv";
		
		
		System.out.println("Is this done");
		
		
	

	}
	
	
	public void run(){
		
		
		
		
		nodes = new HashSet();
		
		/*
		 * I am going to first simulate the creation of nodes
		 */
		Node lond = new Node("London");
		Link londl1 = new Link();
		londl1.setSource(lond);
		Node dub = new Node("Dublin");
		londl1.setDestination(dub);
		
	}
	
	
	private Set<Node> nodes;

}
