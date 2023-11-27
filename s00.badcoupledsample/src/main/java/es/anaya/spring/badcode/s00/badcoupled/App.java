package es.anaya.spring.badcode.s00.badcoupled;

public class App {
	public static void main(String[] args) {
		CustomerList customerList = new CustomerList();
		customerList.loadFile("samplefile.csv", ";");
		System.out.println(customerList.showAll());	
	}
}
