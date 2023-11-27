package es.anaya.spring.basic.s01.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"es","default"})
public class MessageGeneratorInSpanish implements MessageGenerator {

	@Override
	public String startProgram() {
		return "Iniciando programa...";
	}

	@Override
	public String endProgram() {
		return "Finalizando programa...";
	}
}
