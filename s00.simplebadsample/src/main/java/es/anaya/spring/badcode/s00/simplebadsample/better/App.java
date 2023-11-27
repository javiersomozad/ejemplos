package es.anaya.spring.badcode.s00.simplebadsample.better;


public class App {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("0666EVL", "Opel Corsa");
		Traveller tourist = new Traveller("Dr. Livingstone", vehicle);
		
		System.out.println("Moving! Cost: " + tourist.move(15) + "$");
		System.out.println("Moving! Cost: " + tourist.move(1) + "$");
		System.out.println("Moving! Cost: " + tourist.move(42) + "$");
	}
}
