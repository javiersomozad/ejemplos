package es.anaya.spring.services.s05.webservicesclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("es.anaya.spring.services.s05.webservices");
    return marshaller;
  }

  @Bean
  public StockWebServiceClient quoteClient(Jaxb2Marshaller marshaller) {
    StockWebServiceClient stockClient = new StockWebServiceClient();
    stockClient.setDefaultUri("http://localhost:8080/ws");
    stockClient.setMarshaller(marshaller);
    stockClient.setUnmarshaller(marshaller);
    return stockClient;
  }

}