package es.anaya.spring.data.s03.jpamultisource.h2source;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2CustomerRepository 
			extends JpaRepository<Customer, Long> {
}