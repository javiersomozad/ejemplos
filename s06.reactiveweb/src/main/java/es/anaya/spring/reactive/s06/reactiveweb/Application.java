package es.anaya.spring.reactive.s06.reactiveweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application implements CommandLineRunner {
	 
	 @Autowired
	 private NoteReactiveRepository repository;

	 public static void main(String[] args) {
	  SpringApplication.run(Application.class, args);
	 }
	 
	 @Override
	 public void run(String... args) throws Exception {


	  repository.deleteAll()
      .thenMany(
      Flux.just("Learn React","Learn Vue","Learn Angular 5")
              .map(note -> new Note(note))
              .flatMap(repository::save))
              .subscribe(null, null, () -> {
            	  repository.findAll().subscribe(System.out::println);
              });
	  
	  System.out.println(repository.findAll());

	 }
}
