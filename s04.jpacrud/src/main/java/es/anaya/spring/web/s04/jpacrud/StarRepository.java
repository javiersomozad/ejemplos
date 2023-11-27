package es.anaya.spring.web.s04.jpacrud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StarRepository extends CrudRepository<Star, Long> {

    List<Star> findByName(String name);

}