package es.anaya.spring.testing.s04.exceptions.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import es.anaya.spring.testing.s04.exceptions.command.ProductCommand;
import es.anaya.spring.testing.s04.exceptions.domain.Product;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand> {

  @Synchronized
  @Nullable
  @Override
  public ProductCommand convert(Product product) {
    if (product == null) {
      return null;
    }

    final ProductCommand productCommand = new ProductCommand();

    productCommand.setId(product.getId());
    productCommand.setName(product.getName());
    productCommand.setPrice(product.getPrice());

    return productCommand;
  }
}