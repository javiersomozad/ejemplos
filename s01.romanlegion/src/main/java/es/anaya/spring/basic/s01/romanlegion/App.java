package es.anaya.spring.basic.s01.romanlegion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Legion legio = (Legion) context.getBean("legion");

		System.out.println("Legion was created: " + legio);

		((ConfigurableApplicationContext) context).close();
	}
}