package es.anaya.spring.reactive.s06.helloreactive;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveOperations {
 
 public Product monoQuery (Product product) {
    Mono<Product> productMonoStream = Mono.just(product);
    return productMonoStream.block();
 }
 
 public Product monoQueryFilter (Product aProduct) {
    Mono<Product> productMonoStream = Mono.just(aProduct);
    
    return productMonoStream
      .filter(product -> product.getPrice() > 1.0)
      .block();
 }
 
 public ProductCommand monoQueryMap (Product aProduct) {
    Mono<Product> productMonoStream = Mono.just(aProduct);
    
    return productMonoStream
      .map(product -> new ProductCommand(product))
      .block();
 }
 
 public void fluxQuery (Product ...products) {
    Flux<Product> productFluxStream = Flux.just(products);
    
    productFluxStream
      .subscribe(product -> System.out.println(product));
 }
 
 public void fluxQueryFilter (Product ...products) {
    Flux<Product> productFluxStream = Flux.just(products);
    
    productFluxStream
      .filter(product -> product.getName().contains("Sidra"))
      .subscribe(product -> System.out.println(product));
 }

 public void fluxQueryMap (Product ...products) {
    Flux<Product> productFluxStream = Flux.just(products);
    
    productFluxStream
      .map(product -> new ProductCommand(product))
      .subscribe(productCommand -> System.out.println(productCommand));
 }

 public void fluxQueryDelay (Product ...products) throws InterruptedException {
    Flux<Product> productFluxStream = Flux.just(products);
    CountDownLatch countDownLatch = new CountDownLatch(2);
    
    productFluxStream
      .delayElements(Duration.ofSeconds(2))
      .doOnComplete(countDownLatch::countDown)
      .subscribe(product -> System.out.println(product));
    
    countDownLatch.await();
 }

}
