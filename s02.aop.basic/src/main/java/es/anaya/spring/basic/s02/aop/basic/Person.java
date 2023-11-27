package es.anaya.spring.basic.s02.aop.basic;

public class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void saySomething() {
		System.out.println(name + " says hello");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}
