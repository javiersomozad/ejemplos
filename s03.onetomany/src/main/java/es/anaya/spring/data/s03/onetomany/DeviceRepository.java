package es.anaya.spring.data.s03.onetomany;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public interface DeviceRepository extends CrudRepository<Device, Long> {
	
    List<Device> findByName(String name);

}