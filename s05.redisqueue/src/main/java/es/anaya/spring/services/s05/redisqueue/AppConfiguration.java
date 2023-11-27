package es.anaya.spring.services.s05.redisqueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class AppConfiguration {
  
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
      return new JedisConnectionFactory();
  }
   
  @Bean
  public RedisTemplate<String, String> redisTemplate() {
    StringRedisTemplate template = new StringRedisTemplate();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
  }

  @Bean
  RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
      MessageListenerAdapter listenerAdapter) {

    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.addMessageListener(listenerAdapter, new PatternTopic("alarm_channel"));

    return container;
  }

  @Bean
  MessageListenerAdapter listenerAdapter(AlarmReceiver receiver) {
    return new MessageListenerAdapter(receiver, "receiveMessage");
  }

  @Bean
  AlarmReceiver receiver() {
    return new AlarmReceiver();
  }

  @Bean
  StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
    return new StringRedisTemplate(connectionFactory);
  }
  
}
