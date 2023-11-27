package es.anaya.spring.data.s03.inheritancetablepersubclass;

import javax.persistence.Entity;


@Entity
public class Airplane extends MotorVehicle {
	private Integer engines;
	
	public Airplane() {
	}

	public Airplane(String name, Float range, Integer engines) {
		super(name, range);
		this.engines = engines;
	}

	public Integer getEngines() {
		return engines;
	}

	public void setEngines(Integer engines) {
		this.engines = engines;
	}

	@Override
	public String toString() {
		return "Airplane [engines=" + engines + "]" + super.toString();
	}
	

}
