package es.anaya.spring.basic.s01.stereotypes.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.anaya.spring.basic.s01.stereotypes.school.teacher.Teacher;

@Component
public class Subject {
	@Value("Chemistry")
	private String name;
	@Value("1")
	private Integer course;
	
	@Autowired
	private Teacher teacher;
	
	public Subject () {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", course=" + course + ", teacher=" + teacher + "]";
	}
	
	
}
