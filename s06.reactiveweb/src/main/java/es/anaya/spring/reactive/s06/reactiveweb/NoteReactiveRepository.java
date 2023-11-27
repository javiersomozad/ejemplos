package es.anaya.spring.reactive.s06.reactiveweb;

import java.util.Date;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface NoteReactiveRepository extends ReactiveMongoRepository<Note, Integer> {
	Flux<Note> findByText(String text);
    Flux<Note> findByDate(Date date);
}