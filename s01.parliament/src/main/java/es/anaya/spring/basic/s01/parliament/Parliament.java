package es.anaya.spring.basic.s01.parliament;

import java.util.ArrayList;
import java.util.List;

public class Parliament {
	private Integer year;
	private String name;
	private List<Member> members = new ArrayList<Member>();
	
	public Parliament () {
		
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Parliament [year=" + year + ", name=" + name + ", members=" + members + "]";
	}
	
}
