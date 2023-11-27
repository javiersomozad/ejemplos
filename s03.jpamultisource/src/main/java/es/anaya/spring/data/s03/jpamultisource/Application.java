package es.anaya.spring.data.s03.jpamultisource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.anaya.spring.data.s03.jpamultisource.h2source.H2CustomerRepository;
import es.anaya.spring.data.s03.jpamultisource.mysqlsource.MysqlCustomerRepository;



@SpringBootApplication
public class Application implements CommandLineRunner {

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
  @Autowired
  H2CustomerRepository h2CustomerRepository;
  
  @Autowired
  MysqlCustomerRepository mysqlCustomerRepository;

  @Transactional(readOnly = true)
  @Override
  public void run(String... args) throws Exception {
    
   System.out.println("MySQL: " + mysqlCustomerRepository.findAll());
   System.out.println("H2: " + h2CustomerRepository.findAll());
  }
}
