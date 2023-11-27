package es.anaya.spring.basic.s01.parliament;

public class Party {
	private String name;
	private String ideology;
	private Integer year;
	
	public Party () {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdeology() {
		return ideology;
	}

	public void setIdeology(String ideology) {
		this.ideology = ideology;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Party [name=" + name + ", ideology=" + ideology + ", year=" + year + "]";
	}

}
