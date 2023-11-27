package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.anaya.spring.basic.s01.qualifiers.annotations.Cheap;
import es.anaya.spring.basic.s01.qualifiers.annotations.Expensive;

@Configuration
public class AppConfiguration {
	
	@Bean
	@Qualifier("arduino1")
	public Computer generateArduino () {
		return new Arduino("uno");
	}
	
	@Bean
	@Qualifier("arduino2")
	public Computer generateArduinoExtreme () {
		return new Arduino("extreme");
	}
	
	@Bean
	@Cheap
	public Computer generateACheapOne () {
		return new Arduino("serial");
	}

	@Bean
	@Expensive
	public Computer generateAnExpensiveOne () {
		return new Laptop();
	}
	
}
