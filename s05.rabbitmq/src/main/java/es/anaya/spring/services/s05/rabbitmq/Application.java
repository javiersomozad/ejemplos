package es.anaya.spring.services.s05.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private final RabbitTemplate rabbitTemplate;
  private final ConfigurableApplicationContext context;

  public Application(RabbitTemplate rabbitTemplate,
      ConfigurableApplicationContext context) {
    this.rabbitTemplate = rabbitTemplate;
    this.context = context;
  }
  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Main> Send message through queue");
    String message = "RabbitMQ rules";
    rabbitTemplate.convertAndSend(AppConfiguration.QUEUE_NAME, message);
    
    SecretMessage secretMessage = 
    		new SecretMessage("JavaScript rules");
    rabbitTemplate.convertAndSend(AppConfiguration.QUEUE_NAME, secretMessage);
    context.close();
  }

}
