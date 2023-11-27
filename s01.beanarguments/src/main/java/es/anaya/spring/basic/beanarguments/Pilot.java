package es.anaya.spring.basic.beanarguments;

public class Pilot {
	private String name;
	private String license;
	
	public Pilot () {
		System.out.println("Captain> default constructor called");
	}
	
	public Pilot(String name, String license) {
		this.name = name;
		this.license = license;
		System.out.println("Captain> constructor called with params: " 
								+ name + ", " + license);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Pilot [name=" + name + ", license=" + license + "]";
	}
	
	
	
}
