package es.anaya.spring.data.s03.profiles;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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

	        System.out.println("DATASOURCE = " + dataSource);

	        System.out.println("Showing all records");
	        for (Customer customer : customerRepository.findAll()) {
	            System.out.println(customer);
	        }

	        System.out.println("Select by name");
	        for (Customer customer : customerRepository.findByName("%java%")) {
	            System.out.println(customer);
	        }

	    }
}
