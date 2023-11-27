package es.anaya.spring.basic.s01.lifecycle.replicant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Replicant replicant = (Replicant) context.getBean("replicant");
		BladeRunner bladeRunner = (BladeRunner) context.getBean("bladeRunner");
		
		((ConfigurableApplicationContext) context).close();
	}
}