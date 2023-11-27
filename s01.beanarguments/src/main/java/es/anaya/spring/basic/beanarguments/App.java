package es.anaya.spring.basic.beanarguments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Airplane myAirplane = (Airplane) context.getBean("airplane");
		System.out.println("Airplane was created " + myAirplane);

		((ConfigurableApplicationContext) context).close();
	}
}