package es.anaya.spring.basic.s01.nested.workplace;

public class Laptop {
	private String model;
	private String os;
	
	public Laptop(String model, String os) {
		this.model = model;
		this.os = os;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return "Laptop [model=" + model + ", os=" + os + "]";
	}

	
	

}
