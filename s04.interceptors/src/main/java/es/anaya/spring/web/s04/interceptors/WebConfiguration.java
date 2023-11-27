package es.anaya.spring.web.s04.interceptors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	SpyInterceptor spyInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(spyInterceptor);
	}
}