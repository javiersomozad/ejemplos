package es.anaya.spring.basic.s01.autowired.house;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	@Value("Charles Dexter Ward")
	private String name;

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
