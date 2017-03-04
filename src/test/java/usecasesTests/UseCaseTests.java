package usecasesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

import delivery.DeliveryCostEstimator;
import delivery.InputManager;


/*
 * Need to move the responsability of the InputManager partion of strings to test manager
 * and InputManager here.
 * 
 */
public class UseCaseTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private String value2;
	
	private String[] names = {"yasser","alejandro","palacios","otero","otero"};
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	private InputManager inputManager;
	
	private List<List<String>> testList;
	
	
	@Test
	public void testFileDirectory() {	
		//System.out.println("Please enter the location of your test directory");
		//String dirAddress = manualScanner.nextLine();
		String dirAddress = "C:\\Users\\YasserAlejandro\\Dropbox\\JobSearch\\InterviewPrep\\Allpago\\test";
		dir=new File(dirAddress);
		Boolean dirExist;
		dirExist=dir.exists();
		assertEquals(true,dirExist);
		File[] files = null;
		Integer numberofFiles=0;
		if (dirExist){
			files = dir.listFiles();
			numberofFiles=files.length;
			assertTrue(numberofFiles>0);
		}
		if (numberofFiles>0){
			for (int i=0;i<numberofFiles;i++){
				File temp = files[i];
				try {
					fileScanner = new Scanner(new FileReader(temp));
				} catch (FileNotFoundException ex){
					ex.printStackTrace();
				}
				//deliveryCostEstimator = new DeliveryCostEstimator(fileScanner);
				//deliveryCostEstimator.launchEstimator();
				//System.out.println(fileScanner.next());
				
				inputManager = new InputManager(fileScanner);
				//inputManager.print();
				inputManager.processInput("@",",");
				inputManager.startCalculators();
				System.out.println(inputManager.getEstimate("A","G"));
				System.out.println(inputManager.getWeight(26,10,11,2));
				
				//System.out.println(deliveryCostEstimator.getEstimate("A","G"));
				//System.out.println(deliveryCostEstimator.getWeight(26,10,11,1));
			
			}
			
			System.out.println("Ale Tonto");
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	//@Test
	public void testFile(String first, String second){
		//value1 = "Alejandro";
		//value2 = "Alejandro";
		assertEquals(first,second);
	}
	
	

}
