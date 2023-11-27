package es.anaya.spring.basic.s01.nested.workplace;

public class Building {
	private String name;
	private String address;
	private String city;
	
	public Building() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Building [name=" + name + ", address=" + address + ", city=" + city + "]";
	}
	
	

}
