package delivery;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DeliveryFactory {
	
	public static BeanFactory getBeanFactory(){
		
		BeanFactory factory = new ClassPathXmlApplicationContext("delivery/beans.xml");
		return factory;
	}
	
	

}
