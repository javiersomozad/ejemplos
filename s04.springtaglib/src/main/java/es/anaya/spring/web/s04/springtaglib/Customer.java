/**
 * 
 */
package es.anaya.spring.web.s04.springtaglib;

import org.springframework.stereotype.Component;

/**
 * Simple pojo representing a Customer
 *
 */
@Component
public class Customer {
	private long id;
	private String name;
	private String address;
	private String email;
	
	/**
	 * default constructor
	 */
	public Customer () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param email
	 */
	public Customer(long id, String name, String address, String email) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		System.out.println("Bean created: " + this.name);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
