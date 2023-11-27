package es.anaya.spring.basic.s01.primarybean;

import org.springframework.stereotype.Component;

@Component
public class GentleGreeter implements Greeter {

	@Override
	public String greet() {
		return "How are you today?";
	}

}
