package es.anaya.spring.data.s03.manytomany;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface NewspaperRepository extends CrudRepository<Newspaper, Long> {
    List<Newspaper> findByName(String name);
}