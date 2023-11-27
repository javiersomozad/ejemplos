package es.anaya.spring.basic.s01.primarybean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RudeGreeter implements Greeter {

	@Override
	public String greet() {
		return "Yo, what's up";
	}
}
