package es.anaya.spring.data.s03.embeddable;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByAddress(Address address);
}