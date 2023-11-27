package es.anaya.spring.basic.s01.romanlegion;

public class Triari extends Unit {

	public Triari(String name) {
		super(name);
	}

	@Override
	public Integer getAttack() {
		return super.getAttack() + 4;
	}

	@Override
	public Integer getDefense() {
		return super.getDefense() + 4;
	}
	
}
