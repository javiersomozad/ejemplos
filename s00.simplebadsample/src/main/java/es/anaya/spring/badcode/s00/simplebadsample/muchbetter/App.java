package es.anaya.spring.badcode.s00.simplebadsample.muchbetter;


public class App {
	public static void main(String[] args) {
		Vehicle vehicle = new Car("0666EVL", "Opel Corsa");
		Vehicle otherVehicle = new Train("Talgo 42");
		
		Traveller tourist = new Traveller("Dr. Livingstone", vehicle);
		
		System.out.println("Moving! Cost: " + tourist.move(15) + "$");
		System.out.println("Moving! Cost: " + tourist.move(1) + "$");
		
		tourist.setVehicle(otherVehicle);
		System.out.println("Moving! Cost: " + tourist.move(42) + "$");
	}
}
