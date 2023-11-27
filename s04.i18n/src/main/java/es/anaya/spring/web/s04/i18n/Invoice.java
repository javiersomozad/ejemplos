package es.anaya.spring.web.s04.i18n;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Invoice {
	private Long id;
	private String customer;
	private Double total;
	@DateTimeFormat(pattern="YYYY-mm-DD")
	private Date date;
	
	public Invoice () {
		date = new Date();
	}

	public Invoice(String customer, Double total) {
		this.customer = customer;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customer=" + customer + ", total=" + total + ", date=" + date + "]";
	}
	
}
