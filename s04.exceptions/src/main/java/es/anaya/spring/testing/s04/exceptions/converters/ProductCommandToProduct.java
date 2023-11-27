package es.anaya.spring.testing.s04.exceptions.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import es.anaya.spring.testing.s04.exceptions.command.ProductCommand;
import es.anaya.spring.testing.s04.exceptions.domain.Product;

@Component
public class ProductCommandToProduct 
		implements Converter<ProductCommand, Product>{

  @Synchronized
  @Nullable
  @Override
  public Product convert(ProductCommand productCommand) {
    if (productCommand == null) {
      return null;
    }

    final Product product = new Product();
    product.setId(productCommand.getId());
    product.setName(productCommand.getName());
    product.setPrice(productCommand.getPrice());
    return product;
 }
}