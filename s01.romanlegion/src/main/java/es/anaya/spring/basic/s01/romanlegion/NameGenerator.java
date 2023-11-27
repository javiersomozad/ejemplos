package es.anaya.spring.basic.s01.romanlegion;

import java.util.Random;

public class NameGenerator {
	private String[] praenomen = 
			{"Caius","Maximus","Casius","Augustus","Lucius",
				"Titus","Marcus","Decimus","Quintus","Publius"};
	private String[] nomen = 
			{"Contomatus","Tulio","Plinio","Aquilio","Claudio",
			  	"Horacio","Graco","Suplpicio","Tiberio","Livio"};
	private String[] cognomen = 
			{"Scipio","Pompeio","Julia","Aneo","Ciceron",
			  	"Craso","Druso","Galba","Crispo","Cato"};
	private Random random = new Random();
	
	public String generate() {
		return randomPraenomen() + " "
				+ randomNomen() + " "
				+ randomCognomen();
	}
	
	private String randomPraenomen() {
		return praenomen[random.nextInt(praenomen.length)];
	}
	
	private String randomNomen() {
		return nomen[random.nextInt(nomen.length)];
	}
	
	private String randomCognomen() {
		return cognomen[random.nextInt(cognomen.length)];
	}
}
