package es.anaya.spring.basic.s01.romanlegion;

import java.util.ArrayList;
import java.util.List;

public class Legion {
	private String name;
	private String location;
	private List<Unit> infantry = new ArrayList<Unit>();
	private List<Equite> equites = new ArrayList<Equite>();
	private Consul consul;
	
	public Legion(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public List<Unit> getInfantry() {
		return infantry;
	}

	public void setInfantry(List<Unit> infantry) {
		this.infantry = infantry;
	}

	public List<Equite> getEquites() {
		return equites;
	}

	public void setEquites(List<Equite> equites) {
		this.equites = equites;
	}

	public Consul getConsul() {
		return consul;
	}

	public void setConsul(Consul consul) {
		this.consul = consul;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Legion [name=" + name + ", location=" + location + ", infantry=" + infantry + ", equites=" + equites
				+ ", consul=" + consul + "]";
	}
	
}
