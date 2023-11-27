package es.anaya.spring.basic.s01.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import es.eugeniaperez.beans.SimpleBean;

@SpringBootApplication
@ComponentScan("es.eugeniaperez.*")
public class Application implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(Application.class);
    
 	@Autowired
    SimpleBean simpleBean;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
	 	logger.debug("Main(Debug)> debug level message");
        logger.info("Main(Info)> info level message");
        logger.warn("Main(Warn)> warn level message");
        logger.error("Main(Error)> error level message");
        logger.fatal("Main(Fatal)> fatal level message");
        
        System.out.println("Current level in main is: " + logger.getLevel().toString());
        
    	simpleBean.doSomething();
    }
}