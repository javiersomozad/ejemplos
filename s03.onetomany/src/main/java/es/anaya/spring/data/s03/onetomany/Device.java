package es.anaya.spring.data.s03.onetomany;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date since;
	
	public Device () {}
	
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
	public Date getSince() {
		return since;
	}
	public void setSince(Date since) {
		this.since = since;
	}

	@Override
	public String toString() {
		return "\n\tDevice [id=" + id + ", name=" + name + ", since=" + since + "]";
	}
	
	
}
