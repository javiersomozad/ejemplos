package es.anaya.spring.basic.s01.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("en")
public class MessageGeneratorInEnglish 
				implements MessageGenerator {

	@Override
	public String startProgram() {
		return "Starting program...";
	}

	@Override
	public String endProgram() {
		return "Ending program...";
	}
}
