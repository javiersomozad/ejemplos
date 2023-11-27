package es.anaya.spring.basic.s01.ymlproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  Environment environment;
  
  @Autowired
  private Logger logger;
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(logger.log("We log this message"));
    System.out.println("Yml: " + environment.getProperty("other.config.name"));  
    System.out.println("Yml:" + environment.getProperty("samples.strings.multiline"));
    System.out.println("Yml:" + environment.getProperty("samples.objects.customer.name"));
    System.out.println("Yml:" + environment.getProperty("samples.lists.weapons[2]"));
  }
}
