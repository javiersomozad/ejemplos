package es.anaya.spring.data.s03.manytomanybidir;

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
  Newspaper newspaper = newspaperRepository.findOne(1L);
  
  System.out.println("From subs: " + newspaper.getSubscriptors().get(0).getNewspapers());
  
  newspaperRepository.delete(newspaper);
  
  Newspaper newspaper2 = new Newspaper();

  newspaper.setName("Spring Gazette");
  
  newspaper2.getSubscriptors().add(new Subscriptor());
  newspaper2.getSubscriptors().add(new Subscriptor());
  
  newspaperRepository.save(newspaper2);
  
  System.out.println("All: " + newspaperRepository.findAll());
  }
 }
