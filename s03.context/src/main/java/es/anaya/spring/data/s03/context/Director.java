package es.anaya.spring.data.s03.context;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="director")  
	private List<Movie> movies = new ArrayList<Movie>();
	
	public Director() {	}

	
	
	public Director(String name, String country) {
		this.name = name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", name=" + name + ", country=" + country + ", movies=" + movies + "]";
	}
	
	
}
