package es.anaya.spring.basic.s01.parliament;

public class Head {
	private Integer yearElected;
	private Member who;
	
	public Head () {
		
	}
	
	public Integer getYearElected() {
		return yearElected;
	}
	public void setYearElected(Integer yearElected) {
		this.yearElected = yearElected;
	}
	public Member getWho() {
		return who;
	}
	public void setWho(Member who) {
		this.who = who;
	}
	
	
}
