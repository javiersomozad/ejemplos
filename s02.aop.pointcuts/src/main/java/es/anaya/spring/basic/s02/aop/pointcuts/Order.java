package es.anaya.spring.basic.s02.aop.pointcuts;

import java.util.Date;

public class Order {
	private Date date;
	private String name;
	private Double price;
	
	public Order(String name, Double price) {
		this.name = name;
		this.price = price;
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Order [date=" + date + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
