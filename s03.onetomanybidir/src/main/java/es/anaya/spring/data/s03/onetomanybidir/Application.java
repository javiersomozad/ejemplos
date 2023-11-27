package es.anaya.spring.data.s03.onetomanybidir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {


  @Autowired
  BrandRepository brandRepository;

 public static void main(String[] args) {
 SpringApplication.run(Application.class, args);
 }
 
  @Transactional(readOnly = false)
  @Override
  public void run(String... args) throws Exception {

   System.out.println("All: " + brandRepository.findAll());

   System.out.println("By name: " + brandRepository.findByName("LG"));
   
   brandRepository.delete(1L);
   System.out.println("All: " + brandRepository.findAll());

  }
}

