package es.anaya.spring.web.s04.webjpa;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Long> {
    List<News> findByTitle(String title);
}