package es.anaya.spring.data.s03.inheritancetablepersubclass;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
    List<Vehicle> findByName(String name);

}