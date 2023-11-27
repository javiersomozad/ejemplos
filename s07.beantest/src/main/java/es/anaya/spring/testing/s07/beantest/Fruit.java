package es.anaya.spring.testing.s07.beantest;

public abstract class Fruit {
	protected String type = "Default";
	
	public Fruit () {}

	public Fruit(String type) {
		this.type = type;
	}
	
	public String whoAmI () {
		return type + " apple";
	}
}
