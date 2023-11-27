package es.anaya.spring.data.s03.simplejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

@SpringBootApplication
public class Application implements CommandLineRunner {
 
  @Autowired
   DataSource dataSource;

   @Autowired
   TechnologyRepository technologyRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
  @Transactional(readOnly = true)
   @Override
   public void run(String... args) throws Exception {

     System.out.println("DATASOURCE = " + dataSource);

     System.out.println("Showing all records");
     for (Technology technology : technologyRepository.findAll()) {
       System.out.println(technology);
     }

     System.out.println("Select by creation date");
     for (Technology technology : technologyRepository.findByCreationYear(1998)) {
       System.out.println(technology);
     }

     System.out.println("Select by name with stream:");
     technologyRepository
      .findByNameReturnStream("%Java%")
       .forEach( tech -> System.out.println(tech));
   }
}
