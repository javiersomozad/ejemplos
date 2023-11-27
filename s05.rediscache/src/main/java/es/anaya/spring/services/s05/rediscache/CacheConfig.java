package es.anaya.spring.services.s05.rediscache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class CacheConfig {
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
      return new JedisConnectionFactory();
  }
   
  @Bean
  public RedisTemplate<String, Result> redisTemplate() {
      RedisTemplate<String, Result> template = 
    		  new RedisTemplate<String, Result>();
      template.setConnectionFactory(jedisConnectionFactory());
      return template;
  }

}