package es.anaya.spring.basic.s01.xmlandconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Bean
	public ArrayShuffler randomNumber () {
		return new ArrayShuffler();
	} 

}


