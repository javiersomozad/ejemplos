package es.anaya.spring.basic.injection;

public class President {
	private String name;
	
	public President () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "President [name=" + name + "]";
	}
	
	
}
