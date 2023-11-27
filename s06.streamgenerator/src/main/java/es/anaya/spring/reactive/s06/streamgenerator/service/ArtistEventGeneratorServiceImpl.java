package es.anaya.spring.reactive.s06.streamgenerator.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

import org.springframework.stereotype.Service;

import java.util.Arrays;

import es.anaya.spring.reactive.s06.streamgenerator.domain.Artist;
import es.anaya.spring.reactive.s06.streamgenerator.domain.ArtistEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

@Service
public class ArtistEventGeneratorServiceImpl 
	implements ArtistEventGeneratorService {

  private final Random random = new Random();
  private final List<Artist> artists = new ArrayList<Artist>();

  public ArtistEventGeneratorServiceImpl() {
    init();
  }

  private void init() {
    artists.add(new Artist(1L, "Prince", "USA"));
    artists.add(new Artist(2L, "Ed Sheeran", "UK"));
    artists.add(new Artist(3L, "Motorhead", "EEUU"));
  }

  @Override
  public Flux<ArtistEvent> fetchArtistEventStream(Duration period) {
    // https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#generate-java.util.concurrent.Callable-java.util.function.BiFunction-
    return Flux.generate(() -> 0, (BiFunction<Integer, SynchronousSink<ArtistEvent>, Integer>) (index, sink) -> {
      sink.next(this.createArtistEvent());
      return index++;
    }).zipWith(Flux.interval(period)) // sets period
        .map(t -> t.getT1()) // previous zip generates tuple, get just the event
        .log("Artist event generated");
  }

  private ArtistEvent createArtistEvent() {
    List<String> events = Arrays.asList("Concert", "Performance", "Press conference", "Interview", "TV Show");
    List<String> cities = Arrays.asList("London", "San Francisco", "Oviedo", "Pamplona", "Torrelavega");

    return new ArtistEvent(randomElement(events), new java.util.Date(), randomElement(cities),
        randomElement(artists));
  }

  private <T> T randomElement(List<T> elements) {
    return elements.get(random.nextInt(elements.size()));
  }

}
