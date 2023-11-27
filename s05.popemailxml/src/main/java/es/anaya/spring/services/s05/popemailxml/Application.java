package es.anaya.spring.services.s05.popemailxml;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    PopClient popClient = (PopClient) context.getBean("mailman");
    popClient.subscribeToNewMessages();
  }

}
