package es.anaya.spring.testing.s07.beantest;

import org.springframework.stereotype.Component;

@Component
public class Banana extends Fruit {
	@Override
	public String whoAmI () {
		return type + " banana";
	}
}
