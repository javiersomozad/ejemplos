package es.anaya.spring.reactive.s06.streamgenerator;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.anaya.spring.reactive.s06.streamgenerator.domain.ArtistEvent;
import es.anaya.spring.reactive.s06.streamgenerator.service.ArtistEventGeneratorService;
import reactor.core.publisher.Flux;


@SpringBootApplication
public class Application implements CommandLineRunner {

@Autowired
ArtistEventGeneratorService artistEventGeneratorService;

public static void main(String[] args) {
SpringApplication.run(Application.class, args);
}

@Override
public void run(String... args) throws Exception {
 Flux<ArtistEvent> artistEventFlux = 
		 artistEventGeneratorService
		 	.fetchArtistEventStream(Duration.ofMillis(100L));
 
 Consumer<ArtistEvent> println = System.out::println;
 Consumer<Throwable> errorHandler = 
		 e -> System.out.println("Some Error Occurred");

 CountDownLatch countDownLatch = new CountDownLatch(1);
 Runnable allDone = () -> countDownLatch.countDown();

 artistEventFlux.take(30)
      .subscribe(println, errorHandler, allDone);

 countDownLatch.await();
}
}
