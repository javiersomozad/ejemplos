package es.anaya.spring.data.s03.inheritancetablepersubclass;

import javax.persistence.Entity;

@Entity
public class MotorVehicle extends Vehicle {
	private Float drivingRange;

	public MotorVehicle() {
	}

	public MotorVehicle(String name, Float range) {
		super(name);
		this.drivingRange = range;
	}

	public Float getRange() {
		return drivingRange;
	}

	public void setRange(Float range) {
		this.drivingRange = range;
	}

	@Override
	public String toString() {
		return "MotorVehicle [drivingRange=" + drivingRange + "]" + super.toString();
	}

}
