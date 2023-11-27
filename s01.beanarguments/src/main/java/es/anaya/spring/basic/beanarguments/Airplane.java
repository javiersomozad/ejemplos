package es.anaya.spring.basic.beanarguments;

public class Airplane {
	private String model;
	private Integer builtYear;
	private Pilot captain;

	public Airplane(String model, Integer builtYear, Pilot captain) {
		this.model = model;
		this.builtYear = builtYear;
		this.captain = captain;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(Integer builtYear) {
		this.builtYear = builtYear;
	}

	public Pilot getCaptain() {
		return captain;
	}

	public void setCaptain(Pilot captain) {
		this.captain = captain;
	}

	@Override
	public String toString() {
		return "Airplane [model=" + model + ", builtYear=" + builtYear + ", captain=" + captain + "]";
	}

}
