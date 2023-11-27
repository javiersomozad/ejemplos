package es.anaya.spring.data.s03.onetomanybidir;


import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Long> {
    List<Device> findByName(String name);

}