package es.anaya.spring.badcode.s00.simplebadsample;

public class Traveller {
	private String name;
	private Vehicle vehicle = new Vehicle("0042GOD", "Opel Corsa");

	public Traveller(String name) {
		this.name = name;
	}

	public Double move(Integer km) {
		System.out.println("Travelling " + km);
		Double cost = vehicle.move(km);
		return cost;
	}
}
