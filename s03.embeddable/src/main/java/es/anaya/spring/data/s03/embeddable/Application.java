package es.anaya.spring.data.s03.embeddable;

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
 CustomerRepository customerRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = true)
 @Override
 public void run(String... args) throws Exception {

  System.out.println("Showing all records");
  for (Customer customer : customerRepository.findAll()) {
   System.out.println(customer);
  }

  Customer anotherCustomer = new Customer("freddy", "f2@hell.com", new Address("address st", 1));
  customerRepository.save(anotherCustomer);
  
  System.out.println("Select by name");
  for (Customer customer : customerRepository.findByName("freddy")) {
   System.out.println(customer);
  }

 }
}