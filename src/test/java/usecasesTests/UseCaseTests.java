package usecasesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;

import delivery.GraphCreator;
import delivery.GraphCreatorImpl;
import delivery.DijkstraImpl;
import delivery.DeliveryCostEstimator;

public class UseCaseTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private String value2;
	
	private String[] names = {"yasser","alejandro","palacios","otero","otero"};
	
	private GraphCreator graphCreator;
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	
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
					assertEquals(1,0);
				}
		
				//graphCreator = new GraphCreatorImpl();
				//graphCreator.createGraph(fileScanner);
				//DijkstraImpl di = new DijkstraImpl(graphCreator.getGraph());
				//di.getMinDistance("A","G");
				
				deliveryCostEstimator = new DeliveryCostEstimator(fileScanner);
				deliveryCostEstimator.launchEstimator();
				System.out.println(deliveryCostEstimator.getEstimate("A","G"));
				System.out.println(deliveryCostEstimator.getWeight(26,10,11,1));
				
				
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
