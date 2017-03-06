package usecasesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import delivery.DeliveryCostEstimator;

import java.util.List;
import java.util.ArrayList;

/*
 * 
 */
public class UseCaseTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	private String dimDelimiter ="x";
	
	private List<String> failedTest;
	
	
	public int getDimension(String sentence,int pos){
		String [] dimensions = sentence.split(dimDelimiter);
		return Integer.parseInt(dimensions[pos]);
	}
	
	public void processInput(String fileName,String testIndicator,String delimiter,Scanner scanner){
		this.deliveryCostEstimator = new DeliveryCostEstimator();
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
	
	public void testIndividualEstimate(String fileName,String[] sentence, DeliveryCostEstimator deliveryCostEstimator){
		String actualResult= deliveryCostEstimator.getEstimate("ME",sentence[1],getDimension(sentence[2],0),getDimension(sentence[2],1),
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
		//String dirAddress = "C:\\Users\\YasserAlejandro\\Dropbox\\JobSearch\\InterviewPrep\\Allpago\\test";
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
