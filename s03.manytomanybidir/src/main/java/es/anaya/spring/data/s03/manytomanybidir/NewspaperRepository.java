package es.anaya.spring.data.s03.manytomanybidir;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface NewspaperRepository extends CrudRepository<Newspaper, Long> {
	
    List<Newspaper> findByName(String name);


}