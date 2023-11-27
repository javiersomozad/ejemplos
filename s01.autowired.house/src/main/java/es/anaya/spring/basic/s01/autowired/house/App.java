package es.anaya.spring.basic.s01.autowired.house;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		House hauntedHouse = (House) context.getBean("hauntedHouse");

		System.out.println("House was created " + hauntedHouse);

		((ConfigurableApplicationContext) context).close();
	}
}