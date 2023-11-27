package es.anaya.spring.reactive.s06.streamgenerator.service;

import java.time.Duration;

import es.anaya.spring.reactive.s06.streamgenerator.domain.ArtistEvent;
import reactor.core.publisher.Flux;

public interface ArtistEventGeneratorService {
  Flux<ArtistEvent> fetchArtistEventStream(Duration period);
}
