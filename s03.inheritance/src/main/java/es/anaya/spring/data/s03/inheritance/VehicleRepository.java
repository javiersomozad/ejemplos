package es.anaya.spring.data.s03.inheritance;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VehicleRepository 
			extends CrudRepository<Vehicle, Long> {	
    List<Vehicle> findByName(String name);
}