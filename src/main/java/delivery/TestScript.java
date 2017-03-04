package delivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;


public class TestScript {

	public static void main(String[] args) {
		
		TestScript ts = new TestScript();
		ts.run();
		
	}
		
	private Scanner manualScanner = new Scanner(System.in);
	
	private Scanner fileScanner;
	
	private File dir;
	
	private String testSign="@";
	
	private String dirAddress = "C:\\Users\\YasserAlejandro\\Dropbox\\JobSearch\\InterviewPrep\\Allpago\\test";
	
	public void run(){
	
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
				while(fileScanner.hasNext()){
					
					//Pattern.compile(arg0)
					
					//fileScanner.next("ME");
					//System.out.println(fileScanner.next("Me"));
					//System.out.println(fileScanner.next());
				}
				
			}
			
			System.out.println("Ale Tonto");
			
			
		}
		
		
	}
	
	

}
