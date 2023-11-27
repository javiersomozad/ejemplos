package es.anaya.spring.basic.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Country myCountry = (Country) context.getBean("country");
		
		myCountry.setName("españa");
		System.out.println("Country was created " + myCountry);

		((ConfigurableApplicationContext) context).close();
	}
}
