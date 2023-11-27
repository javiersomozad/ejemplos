package es.anaya.spring.basic.s02.aop.pointcuts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Restaurant restaurant = (Restaurant) context.getBean("restaurant");

		System.out.println("Restaurant was created: " + restaurant);

		restaurant.addOrder(new Order("Botella Sidra", 2.95d));
		restaurant.addOrder(new Order("Degustación quesos", 6.89));
		
		System.out.println("Restaurant status: " + restaurant);
		
		((ConfigurableApplicationContext) context).close();
	}
}