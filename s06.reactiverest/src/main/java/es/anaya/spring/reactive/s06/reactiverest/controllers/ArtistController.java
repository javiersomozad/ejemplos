package es.anaya.spring.reactive.s06.reactiverest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import es.anaya.spring.reactive.s06.reactiverest.domain.ArtistEvent;
import es.anaya.spring.reactive.s06.reactiverest.service.ArtistService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artist")
public class ArtistController {
	@Autowired
	private ArtistService artistService;

  @GetMapping(value = "/{id}")
  public Mono<Artist> getArtistById(@PathVariable String id){
    return artistService.findById(id);
  }

  @GetMapping
  public Flux<Artist> getAllArtists(){
  	System.out.println("This is it: " + artistService.findAll());
    return artistService.findAll();
  }

  @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<ArtistEvent> streamArtistEvents(@PathVariable String id){
    return artistService.events(id);
  }
}
