package es.anaya.spring.basic.s01.romanlegion;

import java.util.Random;

public abstract class Unit {
	protected Integer attack;
	protected Integer defense;
	protected Integer movement;
	protected String name;
	private Random random;
	
	public Unit (String name) {
		this.name = name;
	}
	
	private void init () {
		random = new Random();
		System.out.println("Unit> " + name + " intialized");
		attack = random.nextInt(6) + 1;
		defense = random.nextInt(6) + 1;
		movement = random.nextInt(6) + 1;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefense() {
		return defense;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}

	public Integer getMovement() {
		return movement;
	}

	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Unit [attack=" + attack + ", defense=" + defense + ", movement=" + movement + ", name=" + name + "]\n";
	}
	
	
}
