package es.anaya.spring.data.s03.onetoonebidir;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date since;
	private Integer years;
	
	@OneToOne(mappedBy = "license")
	private Bar bar;

	public License () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "\n\tLicense [id=" + id + ", since=" + since + ", years=" + years + "]";
	}
}
