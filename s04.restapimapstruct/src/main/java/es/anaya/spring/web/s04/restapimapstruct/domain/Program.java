package es.anaya.spring.web.s04.restapimapstruct.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude= {"channel"})
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name="emitted_at")
	private Date emittedAt;
	@ManyToOne
	private Channel channel;
}
