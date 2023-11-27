package es.anaya.spring.services.s05.restclient;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Program implements Serializable {

	private Long id;
	private String name;
	private Date emittedAt;
	private Channel channel;

	public Program() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEmittedAt() {
		return emittedAt;
	}

	public void setEmittedAt(Date emittedAt) {
		this.emittedAt = emittedAt;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + ", emittedAt=" + emittedAt + ", channel=" + channel + "]";
	}
}
