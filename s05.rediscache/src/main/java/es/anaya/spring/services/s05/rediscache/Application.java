package es.anaya.spring.services.s05.rediscache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;

@EnableCaching
@SpringBootApplication
//https://medium.com/@MatthewFTech/spring-boot-cache-with-redis-56026f7da83a
public class Application implements CommandLineRunner {

 @Autowired
 ResultService resultService;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = false)
 @Override
 public void run(String... args) throws Exception {

  List<Result> results = resultService.findAll();
  System.out.println("All: " + results);

  for (int i = 0;i < 3; i++)
	  System.out.println("Find by date: " 
		  + resultService.findByDate(results.get(0).getDate()));
 
  for (int i = 0;i < 3; i++)
	  System.out.println("Find by event: " 
		  + resultService.findByEvent(results.get(0).getEvent()));
 }
}
