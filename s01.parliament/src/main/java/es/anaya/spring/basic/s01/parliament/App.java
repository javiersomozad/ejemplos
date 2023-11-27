package es.anaya.spring.basic.s01.parliament;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
  public static void main(String[] args) {
    ApplicationContext context = 
        new ClassPathXmlApplicationContext("beans.xml");

    Parliament parliament = (Parliament) context.getBean("parliament");

    System.out.println("Parliament was formed: " + parliament);

    ((ConfigurableApplicationContext) context).close();
  }
}