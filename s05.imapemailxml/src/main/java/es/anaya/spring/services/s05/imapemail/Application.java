package es.anaya.spring.services.s05.imapemail;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    ImapClient imapClient = (ImapClient) context.getBean("imapClient");
    imapClient.subscribeToNewMessages();
  }

}
