package es.anaya.spring.services.s05.websockets;

import java.util.Date;
import java.util.UUID;

public class Message {
    private String id = UUID.randomUUID().toString();
    private String text;
    private Date date = new Date();
    private String channel;
    private String who;
    
    public Message () {}

    
    
	public Message(String text, String channel, String who) {
		this.text = text;
		this.channel = channel;
		this.who = who;
		this.date = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", date=" + date + ", channel=" + channel + ", who=" + who
				+ "]";
	}



	public String format() {
		return who + "> " + text;
	}
    
    
}
