package es.anaya.spring.reactive.s06.helloreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private ReactiveOperations reactirveOperations;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Product product1 = new Product(1l,"Sidra Menéndez", 2.5f);
    Product product2 = new Product(2l,"Sidra Saizar", 1.5f);
    Product product3 = new Product(3l,"Rosado Chivite", 4.5f);
    
    System.out.println(reactirveOperations.monoQuery(product1));
    System.out.println(reactirveOperations.monoQueryFilter(product1));
    System.out.println(reactirveOperations.monoQueryMap(product1));
    reactirveOperations.fluxQuery(product1, product2, product3);
    reactirveOperations.fluxQueryFilter(product1, product2, product3);
    reactirveOperations.fluxQueryMap(product1, product2, product3);
    reactirveOperations.fluxQueryDelay(product1, product2, product3);
  }
}
