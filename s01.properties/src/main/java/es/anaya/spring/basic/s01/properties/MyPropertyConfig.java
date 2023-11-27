package es.anaya.spring.basic.s01.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({@PropertySource("classpath:myapp.properties"), 
				  @PropertySource("classpath:logger.properties")})
// We could just:
// @PropertySource("classpath:just_one_file.properties")
public class MyPropertyConfig {

	@Value("${myapp.name}")
	private String name;
	
	@Value("${logger.showDate}")
	private Boolean showDate;
	
	@Value("${logger.prefix}")
	private String prefix;
	
	@Bean
	public  Logger logger () {
		Logger logger =  new Logger();
		logger.setPrefix(name + prefix);
		logger.setShowDate(showDate);
		return logger;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties () {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
				new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
