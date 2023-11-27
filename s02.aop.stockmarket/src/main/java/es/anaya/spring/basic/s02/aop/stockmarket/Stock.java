package es.anaya.spring.basic.s02.aop.stockmarket;

public class Stock {
	private String name;
	private Double value;
	
	public Stock(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", value=" + value + "]";
	}
	
}
