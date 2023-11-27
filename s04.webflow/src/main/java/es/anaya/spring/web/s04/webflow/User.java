package es.anaya.spring.web.s04.webflow;

import java.io.Serializable;


public class User implements Serializable {
	private String login;
	private String password;
	private String address;
	private String city;
	private String phone;
	private String email;
	private String url;
	
	public User() {
	}


	public User(String login, String password, String address, String city,
			String phone, String email, String url) {
		this.login = login;
		this.password = password;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.url = url;
	}

	
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", address="
				+ address + ", city=" + city + ", phone=" + phone + ", email="
				+ email + ", url=" + url + "]";
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
