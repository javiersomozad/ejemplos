package es.anaya.spring.badcode.s00.simplebadsample;

public class App {
	public static void main(String[] args) {
		Traveller tourist = new Traveller("Dr. Livingstone");
		
		System.out.println("Moving! Cost: " + tourist.move(15) + "$");
		System.out.println("Moving! Cost: " + tourist.move(1) + "$");
		System.out.println("Moving! Cost: " + tourist.move(42) + "$");
	}
}
