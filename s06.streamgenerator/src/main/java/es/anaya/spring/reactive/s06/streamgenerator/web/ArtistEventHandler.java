package es.anaya.spring.reactive.s06.streamgenerator.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import es.anaya.spring.reactive.s06.streamgenerator.domain.ArtistEvent;
import es.anaya.spring.reactive.s06.streamgenerator.service.ArtistEventGeneratorService;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class ArtistEventHandler {
  private ArtistEventGeneratorService artistEventGeneratorService;
  private final static int SIZE = 20;
  private final static int DELAY = 100;

  public ArtistEventHandler(ArtistEventGeneratorService artistEventGeneratorService) {
    this.artistEventGeneratorService = artistEventGeneratorService;
  }

  public Mono<ServerResponse> fetchArtistEvents(ServerRequest request) {
    int size = Integer.parseInt(request.pathVariable("size"));

    return ok().contentType(MediaType.APPLICATION_JSON).body(
        this.artistEventGeneratorService
        .fetchArtistEventStream(Duration.ofMillis(DELAY))
        .take(SIZE),
          ArtistEvent.class);
  }
  
  public Mono<ServerResponse> fetchArtistEventsByArtistId(ServerRequest request) {
    int size = Integer.parseInt(request.pathVariable("size"));
    int id = Integer.parseInt(request.pathVariable("id"));
    
    return ok().contentType(MediaType.APPLICATION_JSON).body(
        this.artistEventGeneratorService
        .fetchArtistEventStream(Duration.ofMillis(DELAY))
        .filter(a -> a.getArtist().getId() == id)
        .take(SIZE),
          ArtistEvent.class);
  }
  
  
  public Mono<ServerResponse> fetchArtistEventsStream(ServerRequest request) {

    return ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(
        this.artistEventGeneratorService
        .fetchArtistEventStream(Duration.ofMillis(DELAY)),
          ArtistEvent.class);
  }
}