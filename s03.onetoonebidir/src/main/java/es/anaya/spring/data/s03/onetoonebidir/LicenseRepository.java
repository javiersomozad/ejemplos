package es.anaya.spring.data.s03.onetoonebidir;

import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findBySince(Date date);
	License findByBar(Bar bar);
}
