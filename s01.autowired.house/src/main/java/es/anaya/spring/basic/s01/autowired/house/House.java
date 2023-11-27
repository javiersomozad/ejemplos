package es.anaya.spring.basic.s01.autowired.house;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hauntedHouse")
public class House {
	@Value("Derceto")
	private String name;
	@Autowired
	private List<Room> rooms = new ArrayList<Room>();
	@Autowired
	private Person owner;

	public House() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms (List<Room> rooms) {
		this.rooms = rooms;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "House [name=" + name + ", rooms=" + rooms + ", owner=" + owner + "]";
	}

}
