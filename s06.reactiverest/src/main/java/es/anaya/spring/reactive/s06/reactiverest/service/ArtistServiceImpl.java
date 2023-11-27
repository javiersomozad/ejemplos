package es.anaya.spring.reactive.s06.reactiverest.service;

import java.time.Duration;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.anaya.spring.reactive.s06.reactiverest.repositories.ArtistRepository;
import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import es.anaya.spring.reactive.s06.reactiverest.domain.ArtistEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArtistServiceImpl implements ArtistService {
  @Autowired
  private ArtistRepository artistRepository;

  @Override
  public Mono<Artist> findById(String artistId) {
    return artistRepository.findById(artistId);
  }

  @Override
  public Flux<Artist> findAll() {
    return artistRepository.findAll();
  }

  @Override
  public Flux<ArtistEvent> events(String artistId) {
    return Flux.<ArtistEvent>generate(artistEventsStream -> {
      artistEventsStream.next(new ArtistEvent(artistId, new Date()));
    }).delayElements(Duration.ofSeconds(2));
  }
}
