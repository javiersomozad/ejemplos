package es.anaya.spring.data.s03.context;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    List<Director> findByName(String name);
}