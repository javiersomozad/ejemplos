package es.anaya.spring.badcode.s00.badcoupled;

import java.util.ArrayList;

public class CustomerList {
	private CsvFileDataSource csvFileDataSource;
	private ArrayList<String> customerData;
	
	public CustomerList () {
		this.customerData = new ArrayList<String>();
	}
	
	public void loadFile (String filename, String separator) {
		csvFileDataSource = new CsvFileDataSource(filename, separator);
		customerData = csvFileDataSource.loadData();
	}
	
	public String showAll () {
		return customerData.toString();
	}
}
