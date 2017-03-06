package usecasesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import delivery.DeliveryCostEstimator;

/*
 * 
 */
public class UseCaseTests {
	
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private DeliveryCostEstimator deliveryCostEstimator;
	
	private String dimDelimiter ="x";
	
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
				processInput(temp.getName(),"@",",",fileScanner);
			}
		}
				
	}
	
	
	public void testIndividualEstimate(String fileName,String[] sentence, DeliveryCostEstimator deliveryCostEstimator){
		String target = sentence[1];
		System.out.print("Test Source: " +fileName + " -> From: Me To: "+sentence[1] +" ->");
		String actualResult= deliveryCostEstimator.getEstimate("ME",sentence[1],getDimension(sentence[2],0),getDimension(sentence[2],1),
				getDimension(sentence[2],2),getDimension(sentence[2],3));	
		String expectedResult= sentence[3];
		
		System.out.println(" Expected : " +expectedResult + " Calculated : " +actualResult);
		assertEquals(expectedResult,actualResult);
	}
	
	
	

}
