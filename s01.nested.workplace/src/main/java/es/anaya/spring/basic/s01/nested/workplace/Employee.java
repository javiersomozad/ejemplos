package es.anaya.spring.basic.s01.nested.workplace;

public class Employee { 
	private String name;
	private Laptop laptop;
	
	public Employee() {}
	
	public Employee(String name, Laptop laptop) {
		this.name = name;
		this.laptop = laptop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", laptop=" + laptop + "]";
	}


}
