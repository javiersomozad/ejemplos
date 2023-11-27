package es.anaya.spring.basic.s01.configsimple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public RandomNumber randomNumber () {
		return new RandomNumber();
	} 
	
	@Bean
	public RandomLetter randomLetter () {
		return new RandomLetter();
	} 
	
}


