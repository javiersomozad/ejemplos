package es.anaya.spring.testing.s04.exceptions.services;

import java.util.List;
import java.util.Optional;

import es.anaya.spring.testing.s04.exceptions.command.ProductCommand;
import es.anaya.spring.testing.s04.exceptions.domain.Product;

public interface ProductService {
	public Product getById(Long id);
	public List<Product> getProducts();
	public ProductCommand saveProduct(ProductCommand productCommand);
}
