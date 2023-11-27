package es.anaya.spring.testing.s07.beantest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public Apple apple () {
		return new Apple();
	}
	
	@Bean("simpleApple")
	public Apple createApple () {
		return new Apple();
	}
	
	@Bean(name="pinkLadyApple")
	public Apple createPinkLady () {
		return new Apple();
	}
	
	@Bean(name="fujiApple")
	public Apple createFuji() {
		return new Apple();
	}
}
