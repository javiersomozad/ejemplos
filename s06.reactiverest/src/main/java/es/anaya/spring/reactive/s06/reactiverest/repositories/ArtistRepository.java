package es.anaya.spring.reactive.s06.reactiverest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import reactor.core.publisher.Flux;

import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository 
		extends ReactiveMongoRepository<Artist, String> {
	public Flux<Artist> findByName(String name);
	public Flux<Artist> findByCountry(String country);
}