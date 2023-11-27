package es.anaya.spring.testing.s07.beantest;

public class Apple extends Fruit {
	@Override
	public String whoAmI () {
		return type + " apple";
	}
}
