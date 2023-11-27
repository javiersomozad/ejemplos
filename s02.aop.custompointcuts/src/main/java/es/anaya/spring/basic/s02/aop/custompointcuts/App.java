package es.anaya.spring.basic.s02.aop.custompointcuts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PasswordGenerator generator = (PasswordGenerator) context.getBean("generator");
		
		generator.init();
		generator.generate();			
		
		((ConfigurableApplicationContext) context).close();
	}
}