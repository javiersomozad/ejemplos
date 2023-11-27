package es.anaya.spring.basic.s01.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("spect")
public class Spectrum implements Computer {
	public void start () {
		System.out.println("I am a Spectrum");
	}
	public void shutdown() {}
	public void runProgram() {}
}
