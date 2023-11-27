package es.anaya.spring.testing.s04.commandobjects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import es.anaya.spring.testing.s04.i18nvalidation.controllers.OrderController;
import es.anaya.spring.testing.s04.i18nvalidation.domain.Order;
import es.anaya.spring.testing.s04.i18nvalidation.service.OrderServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderControllerTest {

    @Mock
    OrderServiceImpl orderService;

    @Mock
    Model model;

    OrderController orderController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        orderController = new OrderController(orderService);
    }

    @Test
    public void testIndexPage() throws Exception {

        String viewName = orderController.list(model);

        assertEquals("orders", viewName);
        verify(orderService, times(1)).getOrders();
        verify(model, times(1)).addAttribute(eq("orders"), anyList());
    }
    
    @Test
    public void testModelIndexPage() throws Exception {
    	List<Order> orders = new ArrayList();

    	orders.add(new Order(1L,"Order 1",new Date(),5.6d));
    	orders.add(new Order(2L,"Order 2",new Date(),5.6d));    	
    	orders.add(new Order(3L,"Order 3",new Date(),5.6d));  	
    	
    	when(orderService.getOrders()).thenReturn(orders);
    	ArgumentCaptor<List<Order>> argumentCaptor = ArgumentCaptor.forClass(List.class);
    	
        String viewName = orderController.list(model);

        assertEquals("orders", viewName);
        verify(orderService, times(1)).getOrders();
        
        verify(model, times(1)).addAttribute(eq("orders"), argumentCaptor.capture());
        
        List<Order> listInsideController = argumentCaptor.getValue();
        assertEquals(3, listInsideController.size());
    }

}