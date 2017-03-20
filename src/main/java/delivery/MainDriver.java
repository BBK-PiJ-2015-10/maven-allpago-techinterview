package delivery;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import delivery.calculator.weight.NormalizedWeightCalc;
import delivery.calculator.weight.NormalizedWeightCalcImpl;
import delivery.calculator.weight.VolumetricWeightCalc;
import delivery.calculator.weight.VolumetricWeightCalcImpl;
import delivery.DeliveryFactory;

public class MainDriver {

	public static void main(String[] args) {
		

		
		MainDriver md = new MainDriver();
		md.launch();
		 

	}
	
	public void launch(){
		
		NormalizedWeightCalc calcm = (NormalizedWeightCalc)DeliveryFactory.getBeanFactory().getBean("weightcalc");
		System.out.println(calcm.calculateNormalizedWeight(26,10,11,400));
	
		
		
		//BeanFactory factory = getBeanFactory();
		//NormalizedWeightCalc calcm = (NormalizedWeightCalc)factory.getBean("weightcalc");
		//System.out.println(calcm.calculateNormalizedWeight(26,10,11,400));
		
		
		//VolumetricWeightCalc calca = new VolumetricWeightCalcImpl();
		//NormalizedWeightCalc calcm = new NormalizedWeightCalcImpl(calca);
		//System.out.println(calcm.calculateNormalizedWeight(26,10,11,400));
		
	}
	
	
	//private static BeanFactory getBeanFactory(){
		
		//BeanFactory factory = new ClassPathXmlApplicationContext("delivery/beans.xml");
		//return factory;
		
	//}
	
	

}
