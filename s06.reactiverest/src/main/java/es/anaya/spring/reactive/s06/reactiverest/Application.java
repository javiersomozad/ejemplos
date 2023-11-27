package es.anaya.spring.reactive.s06.reactiverest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.bson.types.ObjectId;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import es.anaya.spring.reactive.s06.reactiverest.repositories.ArtistRepository;
import reactor.core.publisher.Flux;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
    private ArtistRepository artistRepository;
	
	@Autowired
	ConsoleClient consoleClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
  @Override
  public void run(String... args) throws Exception {
    artistRepository.deleteAll()
      .thenMany(
        Flux.just("Prince","Death","Motorhead")
              .map(title -> new Artist(new ObjectId(),title,"US"))
              .flatMap(artistRepository::save))
              .subscribe(null, null, () -> {
               artistRepository.findAll().subscribe(System.out::println);
              });
    	
    	Flux<Artist> artistFlux = consoleClient.getArtistStream();
    	artistFlux.subscribe(System.out::println);
    }
}
