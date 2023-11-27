package es.anaya.spring.basic.s01.nested.workplace;

public class Department {
	private String name;
	private Employee boss;
	
	public Department(String name, Employee boss) {
		this.name = name;
		this.boss = boss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getBoss() {
		return boss;
	}

	public void setBoss(Employee boss) {
		this.boss = boss;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", boss=" + boss + "]";
	}
	
	

}
