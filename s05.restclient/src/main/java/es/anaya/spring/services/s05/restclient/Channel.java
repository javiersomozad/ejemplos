package es.anaya.spring.services.s05.restclient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel implements Serializable {

	private Long id;
	private String name;

	private List<Program> programs = new ArrayList<Program>();

	public Channel() {
	}
	

	public Channel(String name, List<Program> programs) {
		this.name = name;
		this.programs = programs;
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

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", programs=" + programs + "]";
	}

}
