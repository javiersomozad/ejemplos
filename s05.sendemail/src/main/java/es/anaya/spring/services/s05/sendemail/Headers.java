package es.anaya.spring.services.s05.sendemail;

public class Headers {
	private String to;
	private String subject;
	private String text;

	public Headers(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}


	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}
	
	
}