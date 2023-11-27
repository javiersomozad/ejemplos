package es.anaya.spring.badcode.s00.badcoupledsamplefixed;

import java.util.ArrayList;

public class CustomerList {
	private CsvFileDataSource csvFileDataSource;
	private ArrayList<String> customerData;
	
	public CustomerList (CsvFileDataSource csvFileDataSource) {
		this.customerData = new ArrayList<String>();
		this.csvFileDataSource = csvFileDataSource;
	}
	
	public void loadFile (String filename, String separator) {
		customerData = csvFileDataSource.loadData();
	}
	
	public String showAll () {
		return customerData.toString();
	}
}
