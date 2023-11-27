package es.anaya.spring.web.s04.defaultconventions;


import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Long> {	
    List<Product> findByName(String name);
}