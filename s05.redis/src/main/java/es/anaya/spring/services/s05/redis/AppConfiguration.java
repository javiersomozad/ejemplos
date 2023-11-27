package es.anaya.spring.services.s05.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfiguration {
  
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
      return new JedisConnectionFactory();
  }
   
  @Bean
  public RedisTemplate<String, Alarm> redisTemplate() {
      RedisTemplate<String, Alarm> template = new RedisTemplate<String, Alarm>();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
  }
}
