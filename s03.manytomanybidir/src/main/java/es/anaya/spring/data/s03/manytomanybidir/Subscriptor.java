
package es.anaya.spring.data.s03.manytomanybidir;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subscriptor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	
	@ManyToMany(mappedBy = "subscriptors")
	private List<Newspaper> newspapers = new ArrayList<Newspaper>();
	
	public Subscriptor () {}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Newspaper> getNewspapers() {
		return newspapers;
	}

	public void setNewspaper(List<Newspaper> newspapers) {
		this.newspapers = newspapers;
	}

	@Override
	public String toString() {
		return "\n\tSubscriptor [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
