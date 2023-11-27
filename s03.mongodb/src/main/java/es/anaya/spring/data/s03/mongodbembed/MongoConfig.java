package es.anaya.spring.data.s03.mongodbembed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig  {
	public @Bean MongoDbFactory mongoDbFactory() {
    return new SimpleMongoDbFactory(new MongoClient(), "test");
  }
}
