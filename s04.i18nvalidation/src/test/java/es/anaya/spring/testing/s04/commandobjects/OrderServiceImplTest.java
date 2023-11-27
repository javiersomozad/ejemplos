package es.anaya.spring.testing.s04.commandobjects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.anaya.spring.testing.s04.i18nvalidation.domain.Order;
import es.anaya.spring.testing.s04.i18nvalidation.converters.OrderCommandToOrder;
import es.anaya.spring.testing.s04.i18nvalidation.repositories.OrderRepository;
import es.anaya.spring.testing.s04.i18nvalidation.service.OrderService;
import es.anaya.spring.testing.s04.i18nvalidation.converters.OrderToOrderCommand;
import es.anaya.spring.testing.s04.i18nvalidation.service.OrderServiceImpl;

public class OrderServiceImplTest {
	
	private es.anaya.spring.testing.s04.i18nvalidation.service.OrderService orderService;
	
	@Mock 
	private OrderRepository orderRepository;
	
	@Mock 
	private OrderToOrderCommand orderToOrderCommand;
	
	@Mock 
	private OrderCommandToOrder orderCommandToOrder;
	
	@Before
	public void setUp () throws Exception {
		MockitoAnnotations.initMocks(this);
		orderService = new OrderServiceImpl(orderRepository,orderToOrderCommand, orderCommandToOrder);
	}
	
	@Test
	public void getBugs () throws Exception {
		
		List<Order> bookData = new ArrayList<Order>();
		bookData.add(new Order());
		bookData.add(new Order());

		when(orderService.getOrders()).thenReturn(bookData);
		List<Order> bugs = orderService.getOrders();
		
		assertEquals(bugs.size(), 2);
		verify(orderRepository, times(1)).findAll();
	}
}
