package es.anaya.spring.services.s05.webservicesclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import es.anaya.spring.services.s05.webservices.GetStockRequest;
import es.anaya.spring.services.s05.webservices.GetStockResponse;

public class StockWebServiceClient  
					extends WebServiceGatewaySupport {
	
  public GetStockResponse getQuote(Long id) {

    GetStockRequest getStockRequest = new GetStockRequest();
    getStockRequest.setId(id);

    System.out.println("Requesting quote for " + id);

    GetStockResponse response = 
      (GetStockResponse) getWebServiceTemplate()
       .marshalSendAndReceive("http://localhost:8080/ws",
      			getStockRequest,
   					new SoapActionCallback("http://localhost:8080/ws"));

    return response;
  }

}
