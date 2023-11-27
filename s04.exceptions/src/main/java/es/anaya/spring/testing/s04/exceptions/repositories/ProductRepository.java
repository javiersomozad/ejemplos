package es.anaya.spring.testing.s04.exceptions.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.anaya.spring.testing.s04.exceptions.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByName(String name);

}
