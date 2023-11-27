package es.anaya.spring.web.s04.post;

import java.util.Date;

public class Message {

	private String title;
	private String content;
	private Date date;
	
	public Message () {
		this.date = new Date();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [title=" + title + ", content=" + content + ", date=" + date + "]";
	}
}