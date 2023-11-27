package es.anaya.spring.testing.s07.integrationtest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CustomerData {
	private List<Customer> customers;
	
	public CustomerData () {
		init();
	}
	private void init () {
		customers = new ArrayList<Customer>();	
    	customers.add(new Customer("John Doe"));
    	customers.add(new Customer("Juan Nadie"));
	}

	public List<Customer> getCustomers() {
		return customers;
	}	
}
