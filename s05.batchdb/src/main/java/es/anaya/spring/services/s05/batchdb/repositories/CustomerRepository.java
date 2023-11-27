package es.anaya.spring.services.s05.batchdb.repositories;

import org.springframework.data.repository.CrudRepository;
import es.anaya.spring.services.s05.batchdb.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


}