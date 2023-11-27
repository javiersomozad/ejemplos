package es.anaya.spring.services.s05.rediscache;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Result implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String event;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String finalResult;

	public Result() {
	}

	public Result(String event, Date date, String finalResult) {
		this.event = event;
		this.date = date;
		this.finalResult = finalResult;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}

	@Override
	public String toString() {
		return "\nResult [id=" + id + ", event=" + event + ", date=" + date + ", finalResult=" + finalResult + "]";
	}

}
