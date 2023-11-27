package es.anaya.spring.testing.s04.i18nvalidation.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.anaya.spring.testing.s04.i18nvalidation.domain.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findByDescription(String description);

}
