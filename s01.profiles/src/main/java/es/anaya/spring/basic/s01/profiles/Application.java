package es.anaya.spring.basic.s01.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
 	@Autowired
    private MessageGenerator messageGenerator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
    	System.out.println(messageGenerator.startProgram());
    	System.out.println(messageGenerator.endProgram());
    }
}
