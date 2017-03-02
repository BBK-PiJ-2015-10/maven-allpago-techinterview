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
		String dirAddress = manualScanner.nextLine();
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
				/*
				System.out.println("Reading File: " +temp.getName());
				System.out.println();
				while(fileScanner.hasNext()){
					System.out.println(fileScanner.nextLine());
				}
				System.out.println();
				*/
				
				
				graphCreator = new GraphCreator();
				graphCreator.captureInput(fileScanner);
				
			}
			
			
			
		}
		
		
		
		
		
		//assertTrue(dir.
		//String[] test = {"ale","tonto"};
		//assertTrue(test.length>3);
		//IsEqual("tonto",1,1);
		//assertEquals(true,(dir=new File(dirAddress)).listFiles().lenght);
		
		
		
		//if ((dir=new File(dirAddress)).exists()){
			//System.out.println("The directory exists");
		//}
		//else {
			//System.out.println("The directory does not exists");
		//}
		//testFile("alejandro","alejandro");
		//testFile("palacios","palacios");
		//assertEquals(2,2);
		
	}
	
	
	//@Test
	public void testFile(String first, String second){
		//value1 = "Alejandro";
		//value2 = "Alejandro";
		assertEquals(first,second);
	}
	
	

}
