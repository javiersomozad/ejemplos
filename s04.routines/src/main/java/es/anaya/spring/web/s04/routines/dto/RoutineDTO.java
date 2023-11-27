package es.anaya.spring.web.s04.routines.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class RoutineDTO {

	private Long id;
	private String task;
	private Integer importance;
	
	public RoutineDTO() {
	}

	public RoutineDTO(Long id, String task, Integer importance) {
		this.id = id;
		this.task = task;
		this.importance = importance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Integer getImportance() {
		return importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	@Override
	public String toString() {
		return "Routine [id=" + id + ", task=" + task + ", importance=" + importance + "]";
	}
	
	
}
