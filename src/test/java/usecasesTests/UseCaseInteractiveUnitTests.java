package usecasestests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import delivery.DeliveryCostEstimator;
//import delivery.DeliveryCostEstimatorImpl;

import java.util.List;
import java.util.ArrayList;

import delivery.DeliveryFactory;

/**
 * @author YasserAlejandro
 * 
 * A test class that provides the ability to perform  test on a DeliveryCostEstimator object.
 * It will request the user for a directory location where all tests are saved, it will read each
 * file on that directory and feed the DeliveryCostEstimator with the input data and perform tests
 * on each test data. If all tests pass a message will print on screen, if any tests fail, information
 * about the failed test will be printed an a JUnit Failure window will be triggered. 
 * 
 */
public class UseCaseInteractiveUnitTests {
	
	//Scanner to capture user input
	private Scanner manualScanner = new Scanner(System.in);
	
	//Scanner to capture input from fileDirectory
	private Scanner fileScanner;
	
	//File object point to directory on disk
	private File dir;
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	//Delimiter that separates the dimmensions on a String input
	private String dimDelimiter ="x";
	
	private List<String> failedTest;
	
	//Starting sourceNodeName
	private String sourceNodeName="ME";
	
	
	// Provides a particular dimension from a String based on a position, a sentence, and a delimeter 
	public int getDimension(String sentence,int pos){
		String [] dimensions = sentence.split(dimDelimiter);
		return Integer.parseInt(dimensions[pos]);
	}
	
	/*
	 * Processes a particular file for testing.
	 * @param fileName indicates the name of the file.
	 * @param testIndicator indicates the String specifying the start of a test line.
	 * @param delimiter indicates the String to use for separating the measuring units.
	 * @param scanner to use to read data from file.
	 */
	public void processInput(String fileName,String testIndicator,String delimiter,Scanner scanner){
		deliveryCostEstimator = ((DeliveryCostEstimator)DeliveryFactory.getBeanFactory().getBean("estimator"));
		
		int calcStarter =0;
		while(scanner.hasNext()){
			String [] sentence = scanner.next().split(delimiter);
			if(!sentence[0].equals(testIndicator)){
				deliveryCostEstimator.feedInput(sentence);
			}
			else {
				calcStarter++;
				if(calcStarter==1){
					deliveryCostEstimator.startCalculators();
				}
				testIndividualEstimate(fileName,sentence,deliveryCostEstimator);
			}		
		}
	}
	
	/*
	 * Executes an individual test
	 * @param fileName indicates the name of the source file.
	 * @param sentence indicates the sentence containing the test data.
	 * @param deliveryCostEstimator contains the DeliveryCostEstimator object being tested.
	 */
	public void testIndividualEstimate(String fileName,String[] sentence, DeliveryCostEstimator deliveryCostEstimator){
		String actualResult= deliveryCostEstimator.getEstimate(sourceNodeName,sentence[1],getDimension(sentence[2],0),getDimension(sentence[2],1),
				getDimension(sentence[2],2),getDimension(sentence[2],3));	
		String expectedResult= sentence[3];
		if (!expectedResult.equals(actualResult)){
			String failedMessage = "FAILED => Test Source: " +fileName + " -> From: Me To: "+sentence[1] +" ->"
					+ " Expected : " +expectedResult + " Calculated : " +actualResult;
			failedTest.add(failedMessage);
		}
	}
		

	
	@Test
	public void testFileDirectory() {	
		failedTest = new ArrayList();
		System.out.println("Please enter the location of your test directory");
		String dirAddress = manualScanner.nextLine();
		dir=new File(dirAddress);
		Boolean dirExist;
		dirExist=dir.exists();
		if(!dirExist){
			System.out.println("Incorrect directory address input. Please re-run test");
		}
		assertEquals(true,dirExist);
		File[] files = null;
		Integer numberofFiles=0;
		if (dirExist){
			files = dir.listFiles();
			numberofFiles=files.length;
			if(numberofFiles<1){
				System.out.println("The directory is empty. Please load files in the directory");
			}
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
				processInput(temp.getName(),"@",",",fileScanner);
			}
		}
		if (!failedTest.isEmpty()){
			for (String failedMessage : failedTest){
				System.out.println(failedMessage);
			}
		}
		else {
			System.out.println("All tests have passed");
		}
		assertEquals(failedTest.isEmpty(),true);
	}
	
	
	
	
	
	

}
