package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import es.anaya.spring.basic.s01.qualifiers.annotations.Expensive;
import es.anaya.spring.basic.s01.qualifiers.annotations.Cheap;
import es.anaya.spring.basic.s01.qualifiers.annotations.ComputerQ;

@SpringBootApplication
@Configuration
@ComponentScan({"es.anaya.spring.basic.s01.qualifiers","es.anaya.spring.basic.s01.qualifiers.annotations"})
public class Application implements CommandLineRunner {

	@Autowired
	@Qualifier("spect")
	private Computer computer1;
	
	@Autowired
	@Qualifier("raspb")
	private Computer computer2;
	
	@Autowired
	@Qualifier("arduino1")
	private Computer computer3;
	
	@Autowired
	@Qualifier("arduino2")
	private Computer computer4;

	@Autowired
	@Cheap
	private  Computer computer5;
	
	@Autowired
	@Expensive
	private  Computer computer6;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting some computers: ");
		computer1.start();
		computer2.start();
		computer3.start();
		computer4.start();
		computer5.start();
		computer6.start();
	}
}
