package es.anaya.spring.basic.s01.nested.workplace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Workplace workPlace = (Workplace) context.getBean("workplace");

		System.out.println("WorkPlace was created: " + workPlace);

		((ConfigurableApplicationContext) context).close();
	}
}