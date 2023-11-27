package es.anaya.spring.web.s04.thymeleaf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private Long id;
	private String name;
	private String email;
	private Date birth;
	private CustomerType type;
	private List<Account> accounts = new ArrayList<Account>();
	
	public Customer () {}
	
	public Customer(Long id, String name, String email, Date birth) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + ", type=" + type
				+ ", accounts=" + accounts + "]";
	}
	
	
	
}
