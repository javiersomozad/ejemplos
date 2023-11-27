package es.anaya.spring.testing.s04.i18nvalidation.service;

import java.util.List;
import java.util.Optional;

import es.anaya.spring.testing.s04.i18nvalidation.commands.OrderCommand;
import es.anaya.spring.testing.s04.i18nvalidation.domain.Order;

public interface OrderService {
	public Optional<Order> getById(Long id);
	public List<Order> getOrders();
	public OrderCommand saveOrder(OrderCommand orderCommand);
}
