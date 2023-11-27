package es.anaya.spring.basic.s01.environment;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	@Resource(name="simpleLogger")
	private SimpleLogger simpleLogger;

	@Autowired
	@Resource(name="loggerWithProperties")
	private SimpleLogger loggerWithProperties;
	

	@Autowired
	@Resource(name="loggerWithDefaultProperties")
	private SimpleLogger loggerWithDefaultProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(simpleLogger.log("Trying logger"));
		System.out.println(loggerWithProperties.log("Trying logger"));
		System.out.println(loggerWithDefaultProperties.log("Trying logger"));
		
		// With eclipse, you must set ENVIRONMENT VARS in run configurations
		System.out.println(environment.getProperty("APP_NAME"));
		System.out.println(environment.getProperty("VERSION"));
	}
}

