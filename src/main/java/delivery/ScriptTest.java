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
		
		Node lond = new Node(1);
		Node dub = new Node(1);
		System.out.println(lond.equals(dub));
		
	

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
