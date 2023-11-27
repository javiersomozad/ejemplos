package es.anaya.spring.basic.s01.xmlandconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Improvement, check how official guide explains it https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#resources-app-ctx-classpathxml
@SpringBootApplication
public class Application implements CommandLineRunner {
  
  @Autowired
  private ArrayShuffler arrayShuffler;
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    Letters myLetters = (Letters) context.getBean("lettersBean");
    Numbers myNumbers = (Numbers) context.getBean("numbersBean");
    
    System.out.println("All letters: " + myLetters.toString());
    System.out.println("All numbers: " + myNumbers.toString());
    
    myLetters.setLetters((String [])arrayShuffler.shuffle(myLetters.getLetters()));
    myNumbers.setNumbers((Integer [])arrayShuffler.shuffle(myNumbers.getNumbers()));  

    System.out.println("All letters: " + myLetters.toString());
    System.out.println("All numbers: " + myNumbers.toString());
    
  }
}