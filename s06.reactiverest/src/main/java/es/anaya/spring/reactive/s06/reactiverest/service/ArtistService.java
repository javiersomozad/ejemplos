package es.anaya.spring.reactive.s06.reactiverest.service;

import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import es.anaya.spring.reactive.s06.reactiverest.domain.ArtistEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArtistService {
	public Flux<ArtistEvent> events(String artistId);
	public Mono<Artist> findById (String artistId);
	public Flux<Artist> findAll();
}
