package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
	public void start () {
		System.out.println("I am a Laptop ");
	}
	public void shutdown() {}
	public void runProgram() {}
}
