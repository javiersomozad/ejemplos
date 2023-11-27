package es.anaya.spring.data.s03.lombok;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;


@Data
@Entity
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	private String description;
	
}
