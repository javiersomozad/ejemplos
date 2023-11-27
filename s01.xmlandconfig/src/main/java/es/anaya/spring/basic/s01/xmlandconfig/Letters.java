package es.anaya.spring.basic.s01.xmlandconfig;

public class Letters {
	private String[] letters = {"a","b","c","d","e","f","g","h"};

	public String[] getLetters() {
		return letters;
	}

	public void setLetters(String[] letters) {
		this.letters = letters;
	}

	@Override
	public String toString() {
		String all = "";
		for (String letter: letters)
			all = all + letter + ", ";
		
		return all;
	}
	
	
}
