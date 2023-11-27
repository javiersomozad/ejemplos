package es.anaya.spring.web.s04.restcrud;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    List<Weather> findByLocation(String location);
}