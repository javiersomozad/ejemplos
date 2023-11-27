package es.anaya.spring.basic.s01.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import es.eugeniaperez.spring.beans.EugeniaBean;
import io.pello.spring.beans.PelloBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@ComponentScan({"es.anaya.*","io.pello.*", "es.eugeniaperez.*"})
public class Application implements CommandLineRunner {
	
	@Autowired
	private EugeniaBean eugeniaBean; // Cannot be found unless we scan
	@Autowired
	private PelloBean pelloBean; // Needs scan
	@Autowired
	private SimpleBean simpleBean;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(eugeniaBean.doStuff());
		System.out.println(pelloBean.doStuff());
		System.out.println(simpleBean.doStuff());		
	}
}
