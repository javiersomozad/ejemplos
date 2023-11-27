package es.anaya.spring.basic.s01.beanscope;

import java.util.ArrayList;
import java.util.List;

public class Platoon {
	private String name;
	private String planet;
	private List<StormTrooper> troopers = new ArrayList<StormTrooper>();
	private Logger logger;

	public Platoon(String name, String planet, Logger logger) {
		this.name = name;
		this.planet = planet;
		this.logger = logger;

		this.logger.log("Platoon instantiated> " + toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

	public List<StormTrooper> getTroopers() {
		return troopers;
	}

	public void setTroopers(List<StormTrooper> troopers) {
		this.troopers = troopers;
	}

	@Override
	public String toString() {
		return "Platoon [name=" + name + ", planet=" + planet + ", troopers=" + troopers + "]";
	}

}
