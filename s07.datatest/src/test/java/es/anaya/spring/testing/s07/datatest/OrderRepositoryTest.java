package es.anaya.spring.testing.s07.datatest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void shouldFindByName() {
    Order simpleOrder = insertOneOrder();

    List<Order> order = orderRepository.findByClient(simpleOrder.getClient());

    assertThat(order.get(0).getClient()).isEqualTo(simpleOrder.getClient());
  }

  @Test
  public void shouldInsert() {
    List<Order> current = (List<Order>) orderRepository.findAll();

    Order simpleOrder = insertOneOrder();

    List<Order> afterInsert = (List<Order>) orderRepository.findAll();

    assertThat(current.size() + 1).isEqualTo(afterInsert.size());
  }

  @Test
  public void shouldUpdate() {
    Order simpleOrder = insertOneOrder();

    simpleOrder.setClient("changed");
    orderRepository.save(simpleOrder);

    Optional<Order> otherOrder = orderRepository.findById(simpleOrder.getId());

    assertThat(otherOrder.get().getClient()).isEqualTo("changed");
  }

  @Test
  public void shouldDelete() {
    Order simpleOrder = insertOneOrder();

    orderRepository.deleteById(simpleOrder.getId());

    assertThat(orderRepository.findById(simpleOrder.getId())).isEmpty();
  }

  private Order insertOneOrder() {
    Order simpleOrder = new Order("alex", new Date(), 66.6d);
    entityManager.persist(simpleOrder);
    entityManager.flush();
    return simpleOrder;
  }
}