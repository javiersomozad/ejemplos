package es.anaya.spring.basic.s01.stereotypes.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.anaya.spring.basic.s01.stereotypes.school.subject.Subject;

@Component
public class Student {
	@Value("Paul")
	private String name;
	@Value("1")
	private Integer course;
	
	@Autowired
	private Subject subject;
	
	public Student () {}

	
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


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + course + ", subject=" + subject + "]";
	}
	
	
}
