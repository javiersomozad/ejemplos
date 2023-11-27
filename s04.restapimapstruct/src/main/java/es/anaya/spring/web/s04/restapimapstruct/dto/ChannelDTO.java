package es.anaya.spring.web.s04.restapimapstruct.dto;

import java.util.ArrayList;
import java.util.List;

public class ChannelDTO {
	private Long id;
	private String name;
	private List<ProgramDTO> programs = new ArrayList<ProgramDTO>();

	public ChannelDTO() {
	}

	public ChannelDTO(Long id, String name, List<ProgramDTO> programs) {
		this.id = id;
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

	public List<ProgramDTO> getPrograms() {
		return programs;
	}

	public void setPrograms(List<ProgramDTO> programs) {
		this.programs = programs;
	}

	@Override
	public String toString() {
		return "ChannelDTO [id=" + id + ", name=" + name + ", programs=" + programs + "]";
	}

}
