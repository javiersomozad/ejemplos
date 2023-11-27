package es.anaya.spring.testing.s07.beantest;

public class Orange extends Fruit {
	@Override
	public String whoAmI () {
		return type + " orange";
	}
}