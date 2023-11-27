package es.anaya.spring.basic.s01.parliament;

import java.util.Date;

public class Member {
	private String name;
	private Date birth;
	private String homeTown;
	private Party party;
	
	public Member () {}
	
	public Member(String name, String homeTown) {
		this.name = name;
		this.homeTown = homeTown;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", birth=" + birth + ", homeTown=" + homeTown + ", party=" + party + "]";
	}
	
	
}
