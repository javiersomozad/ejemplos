package es.anaya.spring.data.s03.onetoonebidir;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BarRepository extends CrudRepository<Bar, Long> {
	List<Bar> findByName(String name);
	List<Bar> findByAddress(String address);
	Bar findByLicense(License license);
}
