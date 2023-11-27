package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("raspb")
public class RaspberryPi implements Computer {
	public void start () {
		System.out.println("I am a RaspberryPi ");
	}
	public void shutdown() {}
	public void runProgram() {}
}
