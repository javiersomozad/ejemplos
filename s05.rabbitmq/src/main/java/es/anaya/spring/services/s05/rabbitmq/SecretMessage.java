package es.anaya.spring.services.s05.rabbitmq;

import java.io.Serializable;
import java.util.Date;

public class SecretMessage implements Serializable {
	private Long id;
	private String text;
	private Date date;
	
	public SecretMessage(String text) {
		id = Math.round(Math.random() * 10000);
		this.text = text;
		date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SecretMessage [id=" + id + ", text=" + text + ", date=" + date + "]";
	}
	
	
	
}
