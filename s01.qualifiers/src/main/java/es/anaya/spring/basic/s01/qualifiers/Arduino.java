package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.stereotype.Component;

@Component
public class Arduino implements Computer {
	private String version;
	
	public Arduino () {}
	
	public Arduino (String version) {
		this.version = version;
	}
	
	public void start () {
		System.out.println("I am an Arduino " + version);
	}
	public void shutdown() {}
	public void runProgram() {}
}
