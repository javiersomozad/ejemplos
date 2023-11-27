package es.anaya.spring.data.s03.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

   @Autowired
   BarRepository barRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
  @Transactional(readOnly = true)
   @Override
   public void run(String... args) throws Exception {
	 License license = new License();
	     
     System.out.println("Showing all records");
     for (Bar bar : barRepository.findAll()) {
       System.out.println(bar);
     }
     
     System.out.println("Select by name");
     for (Bar bar : barRepository.findByName("Bar Buerto")) {
       System.out.println(bar);
     }

     System.out.println("Select by license");
     license.setId(3L);
     System.out.println(barRepository.findByLicense(license));
   }
}

