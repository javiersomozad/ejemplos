package es.anaya.spring.data.s03.lombok;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = {"director","cast"})
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer year;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Plot plot;
	
	@ManyToOne
	private Person director;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
	private List<Person> cast = new ArrayList<Person>();
	
}
