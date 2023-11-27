package es.anaya.spring.basic.s02.aop.stockmarket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Market market = (Market) context.getBean("market");
		Trader trader1 = (Trader) context.getBean("trader1");
		Trader trader2 = (Trader) context.getBean("trader2");
		
		System.out.println("Market status: " + market);
		trader1.buy(0.5d,"AMZN");
		trader2.buy(423d,"NFLX");
		trader2.buy(100d,"AMZN");
		trader2.buy(372d,"AAPL");
		trader2.sell(345d,"AMZN");
		trader1.buy(1d,"AAPL");
		trader2.sell(1000d,"NFLX");
	
		System.out.println("Market status: " + market);
		
		((ConfigurableApplicationContext) context).close();
	}
}