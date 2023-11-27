package es.anaya.spring.data.s03.context;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
}