package es.anaya.spring.badcode.s00.badcoupledsamplefixedwithinterfaces;

import java.util.ArrayList;

public class CustomerList {
	private DataSource dataSource;
	private ArrayList<String> customerData;
	
	public CustomerList (DataSource dataSource) {
		this.customerData = new ArrayList<String>();
		this.dataSource = dataSource;
	}
	
	public void loadFile (String filename, String separator) {
		customerData = dataSource.loadData();
	}
	
	public String showAll () {
		return customerData.toString();
	}
}
