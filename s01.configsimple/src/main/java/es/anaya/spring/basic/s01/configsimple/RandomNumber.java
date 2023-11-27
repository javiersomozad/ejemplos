package es.anaya.spring.basic.s01.configsimple;

import java.util.Random;

public class RandomNumber {
	
	public Integer random () {
		return new Random().nextInt(9000) + 1000;
	}
}
