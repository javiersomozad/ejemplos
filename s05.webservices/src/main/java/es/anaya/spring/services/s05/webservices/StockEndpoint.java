package es.anaya.spring.services.s05.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StockEndpoint {
  private static final String NAMESPACE_URI = "http://anaya.es/spring/services/s05/webservices";

  private StockRepository stockRepository;

  @Autowired
  public StockEndpoint(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStockRequest")
  @ResponsePayload
  public GetStockResponse getStock(@RequestPayload GetStockRequest request) {
    GetStockResponse response = new GetStockResponse();
    response.setStock(stockRepository.findById(request.getId()).get());
  
    return response;
  }
}