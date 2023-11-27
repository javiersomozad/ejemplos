package es.anaya.spring.reactive.s06.streamgenerator.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ArtistEventRouter {

 @Bean
 public RouterFunction<ServerResponse> routes(ArtistEventHandler handler) {
  return RouterFunctions
    .route(GET("/artistevents/{size}")
      .and(accept(MediaType.APPLICATION_JSON)), handler::fetchArtistEvents)
    .andRoute(GET("/artistevents/artist/{id}/{size}")
      .and(accept(MediaType.APPLICATION_JSON)), handler::fetchArtistEventsByArtistId)
    .andRoute(GET("/artisteventsstream")
      .and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::fetchArtistEventsStream);
 }
}