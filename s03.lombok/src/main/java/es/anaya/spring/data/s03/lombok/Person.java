package es.anaya.spring.data.s03.lombok;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude= {"directed","movies"})
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="director")  
	private List<Movie> directed = new ArrayList<Movie>();

	@ManyToMany(mappedBy = "cast")
	private List<Movie> movies = new ArrayList<Movie>();
}
