package es.anaya.spring.testing.s04.commandobjects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import es.anaya.spring.testing.s04.exceptions.controllers.ProductController;
import es.anaya.spring.testing.s04.exceptions.domain.Product;
import es.anaya.spring.testing.s04.exceptions.services.ProductService;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductControllerTest {

  @Mock
  ProductService productService;

  @Mock
  Model model;

  ProductController productController;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    productController = new ProductController(productService);
  }

  @Test
  public void testIndexPage() throws Exception {

    String viewName = productController.list(model);

    assertEquals("products", viewName);
    verify(productService, times(1)).getProducts();
    verify(model, times(1)).addAttribute(eq("products"), anyList());
  }
  
  @Test
  public void testModelIndexPage() throws Exception {
    List<Product> products = new ArrayList();

    products.add(new Product(1L,"a",45f));
    products.add(new Product(2L,"b",5.6f));    
    products.add(new Product(3L,"c", 6.66f));  
    
    when(productService.getProducts()).thenReturn(products);
    ArgumentCaptor<List<Product>> argumentCaptor = ArgumentCaptor.forClass(List.class);
    
    String viewName = productController.list(model);

    assertEquals("products", viewName);
    verify(productService, times(1)).getProducts();
    
    verify(model, times(1)).addAttribute(eq("products"), argumentCaptor.capture());
    
    List<Product> listInsideController = argumentCaptor.getValue();
    assertEquals(3, listInsideController.size());
  }
  


}