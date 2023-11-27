package es.anaya.spring.basic.s01.romanlegion;

public class Equite extends Unit {
	
	public Equite(String name) {
		super(name);
	}

	@Override
	public Integer getAttack() {
		return super.getAttack() + 2;
	}

	@Override
	public Integer getMovement() {
		return super.getMovement() + 4;
	}
	
}
