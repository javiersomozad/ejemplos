package es.anaya.spring.services.s05.redisqueue;

import java.io.Serializable;
import java.util.Date;

public class Alarm implements Serializable {
	private String id;
	private String data;
	private Date date;
	
	public Alarm() {}

	public Alarm(String id, String data, Date date) {
		this.id = id;
		this.data = data;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", data=" + data + ", date=" + date + "]";
	}
}
