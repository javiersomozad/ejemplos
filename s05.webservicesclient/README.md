## s05.webserviceclient

En Spring necesitaremos crear WebServices pero también consumirlos, tanto propios como ajenos. Hacerlo es muy sencillo, ya que nos tenemos que preocupar únicamente de la petición, y gran parte del código generado anteriormente puede ser reutilizado.


Se necesita una clase de configuración. La clave es la definición de un marshaller, ya que este objeto es quien se encarga de las conversiones de XML a instancias Java y viceversa. Debemos indicarle el paquete donde se encuentran las tipos de clases con los que tendrá que trabajar, que son GetStockRequest, GetStockResponse y Stock. Y además, configuramos el cliente que definiremos a continuación. Al cliente le pasamos la URL del WebService además del marshaller.

**Listado - Fichero ClientConfiguration.java.**

```java
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
```

Como cliente, definimos una clase que debe extender WebServiceGatewaySupport, y una vez hecho, se define un método para que haga la petición. Aquí es donde se puede reutilizar la clase GetStockRequest y GetStockResponse:

**Listado - Fichero StockWebServiceClient.java.**

```java

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
```

Ahora en la clase principal podemos utilizar el cliente:

**Listado - Fichero Application.java.**

```java
@SpringBootApplication
public class Application implements CommandLineRunner {
...

  @Override
  public void run(String... args) throws Exception {
    GetStockResponse response = stockWebServiceClient.getQuote(2L);
		 System.out.println(response.getStock());
  }
}
```

Y como salida veremos:

```bash
Requesting quote for 2
Stock [id=2, stock=GOOG, company=Google, stockValue=1060.12]
```
