package es.anaya.spring.badcode.s00.badcoupledsamplefixedwithinterfaces;

public class App {
	public static void main(String[] args) {
		DataSource csvFileDataSource = new CsvFileDataSource("file.csv", ";");
		CustomerList customerList = new CustomerList(csvFileDataSource);
		customerList.loadFile("samplefile.csv", ";");
		System.out.println(customerList.showAll());	
	}
}
