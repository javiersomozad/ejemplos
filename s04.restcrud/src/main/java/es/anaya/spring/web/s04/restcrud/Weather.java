package es.anaya.spring.web.s04.restcrud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String location;
	private Float temperature;
	
	public Weather () {}

	public Weather(String location, Float temperature) {
		this.location = location;
		this.temperature = temperature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", location=" + location + ", temperature=" + temperature + "]";
	}

	
}
