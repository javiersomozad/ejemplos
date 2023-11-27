package es.anaya.spring.basic.s01.configsimple;

import java.util.Random;

public class RandomLetter {
	
	public String random () {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		int index = new Random().nextInt(letters.length()-2);
		return letters.substring(index, index + 1);
	}	
}
