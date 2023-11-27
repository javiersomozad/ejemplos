package es.anaya.spring.basic.s02.aop.pointcuts;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private String name;
	private String address;
	private List<Order> orders = new ArrayList<Order>();
	
	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Integer addOrder (Order order) {
		orders.add(order);

		return new Integer(orders.size());
	}
	
	public Order removeOrder (Integer index) {
		Order removedOrder = null;
		if (index >= 0 && index < orders.size()) {
			removedOrder = orders.get(index);
			return orders.get(index);
		} 
		return removedOrder;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", address=" + address + ", orders=" + orders + "]";
	}
	
	

}
