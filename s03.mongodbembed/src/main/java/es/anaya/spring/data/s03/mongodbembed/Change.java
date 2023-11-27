package es.anaya.spring.data.s03.mongodbembed;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Change {
	private String text;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date changedAt;
	
	public Change () {}
	
	public Change(String text) {
		this.text = text;
		changedAt = new Date();
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Override
	public String toString() {
		return "\n\t\tChange [text=" + text + ", changedAt=" + changedAt + "]";
	}
	
}
