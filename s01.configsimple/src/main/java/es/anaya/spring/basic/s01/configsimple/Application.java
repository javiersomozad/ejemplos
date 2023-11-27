package es.anaya.spring.basic.s01.configsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private PasswordGenerator passwordGenerator; 

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		for (int i = 0; i< 10; i++)
			System.out.println(passwordGenerator.generate());
	}
}
