package es.anaya.spring.services.s05.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  final static String QUEUE_NAME = "anaya-news";

  @Bean
  public Queue queue() {
    return new Queue(QUEUE_NAME, false);
  }

  @Bean
  public TopicExchange exchange() {
    return new TopicExchange("spring-boot-exchange");
  }

  @Bean
  public Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
  }

  @Bean
  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = 
    		new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(QUEUE_NAME);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  public MessageListenerAdapter listenerAdapter(MessageReceiver messageReceiver) {
    return new MessageListenerAdapter(messageReceiver, "receiveMessage");
  }

}
