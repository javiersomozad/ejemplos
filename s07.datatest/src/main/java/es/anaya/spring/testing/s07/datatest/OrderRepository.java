package es.anaya.spring.testing.s07.datatest;

import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByClient(String client);
    List<Order> findByDate(Date date);
}