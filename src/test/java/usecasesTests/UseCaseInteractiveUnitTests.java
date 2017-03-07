package usecasestests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import delivery.DeliveryCostEstimatorImpl;

import java.util.List;
import java.util.ArrayList;

/**
 * @authorAlejandro
 * 
 */
public class UseCaseInteractiveUnitTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private DeliveryCostEstimatorImpl deliveryCostEstimator;
	
	private String dimDelimiter ="x";
	
	private List<String> failedTest;
	
	private String sourceNodeName="ME";
		
	public int getDimension(String sentence,int pos){
		String [] dimensions = sentence.split(dimDelimiter);
		return Integer.parseInt(dimensions[pos]);
	}
	
	public void processInput(String fileName,String testIndicator,String delimiter,Scanner scanner){
		this.deliveryCostEstimator = new DeliveryCostEstimatorImpl();
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
	
	public void testIndividualEstimate(String fileName,String[] sentence, DeliveryCostEstimatorImpl deliveryCostEstimator){
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
