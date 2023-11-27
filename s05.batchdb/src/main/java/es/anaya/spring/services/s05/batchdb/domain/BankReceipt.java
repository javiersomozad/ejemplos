package es.anaya.spring.services.s05.batchdb.domain;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bankreceipt")
public class BankReceipt  {
	private String name;
	private String dni;
	private String account;
	private Double total;
	
	public BankReceipt() {}
	
	public BankReceipt(Customer customer, Double total) {
		this.name = customer.getName();
		this.dni = customer.getDni();
		this.account = customer.getAccount();
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "BankReceipt [name=" + name + ", dni=" + dni + ", account=" + account + ", total=" + total + "]";
	}
	
	
	
}
