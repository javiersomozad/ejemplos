package es.anaya.spring.basic.s01.nested.workplace;

public class Workplace {
	private String name;
	private Building building;
	private Department department;
	private Employee employee;
	
	public Workplace () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Workplace [name=" + name + ", building=" + building + ", department=" + department + ", employee="
				+ employee + "]";
	}
	
	

}
