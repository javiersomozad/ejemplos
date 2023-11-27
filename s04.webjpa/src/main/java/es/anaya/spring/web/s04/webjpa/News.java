package es.anaya.spring.web.s04.webjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String text;
	
	public News () {} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", text=" + text + "]";
	}

	
	
}
