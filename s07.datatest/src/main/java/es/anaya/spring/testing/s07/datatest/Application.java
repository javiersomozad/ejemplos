package es.anaya.spring.testing.s07.datatest;

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
	    OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	  @Transactional(readOnly = true)
	    @Override
	    public void run(String... args) throws Exception {

	        System.out.println("DATASOURCE = " + dataSource);

	        System.out.println("Showing all records");
	        for (Order brand : orderRepository.findAll()) {
	            System.out.println(brand);
	        }
	    }
}

