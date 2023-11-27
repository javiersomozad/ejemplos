package es.anaya.spring.services.s05.webservicesclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import es.anaya.spring.services.s05.webservices.GetStockResponse;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private StockWebServiceClient stockWebServiceClient;

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(false); // avoid Tomcat starting...
		ConfigurableApplicationContext ctx = app.run(args);

	}

	@Override
	  public void run(String... args) throws Exception {
		 GetStockResponse response = stockWebServiceClient.getQuote(2L);
		 System.out.println(response.getStock());
	  }
}
