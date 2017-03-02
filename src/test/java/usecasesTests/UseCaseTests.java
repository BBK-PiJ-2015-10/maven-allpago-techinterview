package usecasesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;

import delivery.GraphCreator;


public class UseCaseTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private String value2;
	
	private String[] names = {"yasser","alejandro","palacios","otero","otero"};
	
	private GraphCreator graphCreator;
	
	
	@Test
	public void testFileDirectory() {	
		System.out.println("Please enter the location of your test directory");
		//String dirAddress = manualScanner.nextLine();
		String dirAddress = "C:\\Users\\YasserAlejandro\\Dropbox\\JobSearch\\InterviewPrep\\Allpago\\test";
		dir=new File(dirAddress);
		Boolean dirExist;
		dirExist=dir.exists();
		assertEquals(true,dirExist);
		File[] files = null;
		Integer numberofFiles=0;
		if (dirExist){
			//System.out.println("I am here");
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
		
				graphCreator = new GraphCreator();
				graphCreator.captureInput(fileScanner);
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	//@Test
	public void testFile(String first, String second){
		//value1 = "Alejandro";
		//value2 = "Alejandro";
		assertEquals(first,second);
	}
	
	

}
