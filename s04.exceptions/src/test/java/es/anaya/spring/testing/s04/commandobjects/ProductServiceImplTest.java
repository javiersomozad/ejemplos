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

import es.anaya.spring.testing.s04.exceptions.converters.ProductCommandToProduct;
import es.anaya.spring.testing.s04.exceptions.converters.ProductToProductCommand;
import es.anaya.spring.testing.s04.exceptions.domain.Product;
import es.anaya.spring.testing.s04.exceptions.repositories.ProductRepository;
import es.anaya.spring.testing.s04.exceptions.services.ProductService;
import es.anaya.spring.testing.s04.exceptions.services.ProductServiceImpl;

public class ProductServiceImplTest {
  
  private ProductService productService;
  
  @Mock 
  private ProductRepository productRepository;
  
  @Mock 
  private ProductToProductCommand productToProductCommand;
  
  @Mock 
  private ProductCommandToProduct productCommandToProduct;
  
  @Before
  public void setUp () throws Exception {
    MockitoAnnotations.initMocks(this);
    productService = new ProductServiceImpl(productRepository,productToProductCommand, productCommandToProduct);
  }
  
  @Test
  public void getBugs () throws Exception {
    
    List<Product> bookData = new ArrayList<Product>();
    bookData.add(new Product());
    bookData.add(new Product());

    when(productService.getProducts()).thenReturn(bookData);
    List<Product> bugs = productService.getProducts();
    
    assertEquals(bugs.size(), 2);
    verify(productRepository, times(1)).findAll();
  }
}
