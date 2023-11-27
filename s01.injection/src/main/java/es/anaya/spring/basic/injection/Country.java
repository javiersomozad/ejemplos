package es.anaya.spring.basic.injection;

public class Country {
	private String name;
	private String continent;
	private President president;
	
	public Country () {
		
	}
	
	public Country(President president) {
		this.president = president;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", continent=" + continent + ", president=" + president + "]";
	}
	
}
