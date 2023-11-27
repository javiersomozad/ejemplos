package es.anaya.spring.basic.s01.configsimple;

import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {
	private RandomLetter randomLetter;
	private RandomNumber randomNumber;
	
	
	public PasswordGenerator(RandomLetter randomLetter, RandomNumber randomNumber) {
		this.randomLetter = randomLetter;
		this.randomNumber = randomNumber;
	}
	
	public String generate () {
		return randomLetter.random() + randomLetter.random() +
				randomLetter.random() + randomNumber.random();
	}
}
