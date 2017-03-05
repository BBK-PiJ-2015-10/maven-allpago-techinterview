package delivery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;


public class TestScript {

	public static void main(String[] args) {
		
		TestScript ts = new TestScript();
		ts.run();
		
	}
		
	
	public void run(){
	
		System.out.println(getEstimate(8.234));
		System.out.println(getEstimate(8.2));
		
		
	}
	
	public String getEstimate(Double number){
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.HALF_EVEN);
		    return df.format(number);
		
	}
	
	

}
