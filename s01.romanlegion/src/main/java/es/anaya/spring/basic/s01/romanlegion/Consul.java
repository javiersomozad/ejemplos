package es.anaya.spring.basic.s01.romanlegion;

public class Consul extends Unit{
	private Integer year;
	
	public Consul(String name) {
		super(name);
	}
	
	@Override
	public Integer getDefense() {
		return super.getDefense() + 10;
	}

	@Override
	public Integer getMovement() {
		return super.getMovement() + 4;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Consul [year=" + year + ", toString()=" + super.toString() + "]";
	}

}
