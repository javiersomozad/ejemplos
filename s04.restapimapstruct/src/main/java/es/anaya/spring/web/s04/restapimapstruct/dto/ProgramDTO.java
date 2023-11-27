package es.anaya.spring.web.s04.restapimapstruct.dto;

import java.util.Date;
import java.util.List;

public class ProgramDTO {

	private Long id;
	private String name;
	private Date emittedAt;

	public ProgramDTO() {
	}

	public ProgramDTO(Long id, String name, Date emittedAt) {
		this.id = id;
		this.name = name;
		this.emittedAt = emittedAt;
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

	public Date getEmittedAt() {
		return emittedAt;
	}

	public void setEmittedAt(Date emittedAt) {
		this.emittedAt = emittedAt;
	}

	@Override
	public String toString() {
		return "ProgramDTO [id=" + id + ", name=" + name + ", emittedAt=" + emittedAt + "]";
	}

}
