package es.anaya.spring.data.s03.manytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

 @Autowired
 NewspaperRepository newspaperRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = false)
 @Override
 public void run(String... args) throws Exception {

  System.out.println("All: " + newspaperRepository.findAll());
  newspaperRepository.delete(1L);
  
  Newspaper newspaper = new Newspaper();
  newspaper.setName("Spring Gazette");
  
  newspaper.getSubscriptors().add(new Subscriptor());
  newspaper.getSubscriptors().add(new Subscriptor());
  
  newspaperRepository.save(newspaper);
  
  System.out.println("All: " + newspaperRepository.findAll());
 }
}
