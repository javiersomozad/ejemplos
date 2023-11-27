package es.anaya.spring.basic.s01.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("fr")
public class MessageGeneratorInFrench implements MessageGenerator {

	@Override
	public String startProgram() {
		return "Début de program...";
	}

	@Override
	public String endProgram() {
		return "Fin de program...";
	}
}
