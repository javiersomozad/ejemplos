package es.anaya.spring.data.s03.onetomanybidir;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface BrandRepository extends CrudRepository<Brand, Long> {
	
    List<Brand> findByName(String name);
    List<Brand> findByCountry(String country);

	// custom query example and return a stream
    @Query("select t from Brand t where t.name = :name")
    Stream<Brand> findByNameReturnStream(@Param("name") String name);

}