package es.anaya.spring.web.s04.jpacrud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;
    private String name;
    private StarType type;
    private Double distance;
	
	public Star () {} 
	
	public Star(String name, StarType type, Double distance) {
		this.name = name;
		this.type = type;
		this.distance = distance;
	}
	
	public Long getId() {
		return id;	
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StarType getType() {
		return type;
	}

	public void setType(StarType type) {
		this.type = type;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Star [id=" + id + ", name=" + name + ", type=" + type + ", distance=" + distance + "]";
	}
}
