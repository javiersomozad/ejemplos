package es.anaya.spring.basic.s01.autowired.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bedroom implements Room {
	@Value("MyRoom")
	private String name;
	@Value("1")
	private Integer floor;
	@Value("false")
	private Boolean hasWindows;
	@Autowired
	private Person person;
	@Autowired
	private Monster monster;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Boolean getHasWindows() {
		return hasWindows;
	}

	public void setHasWindows(Boolean hasWindows) {
		this.hasWindows = hasWindows;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	@Override
	public String toString() {
		return "Bedroom [name=" + name + ", floor=" + floor + ", hasWindows=" + hasWindows + ", person=" + person
				+ ", monster=" + monster + "]";
	}
	
}
