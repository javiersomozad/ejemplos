package es.anaya.spring.data.s03.onetomanybidir;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy="brand")
	private List<Device> devices = new ArrayList<Device>();
	
	public Brand () {
		
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
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	
	@Override
	public String toString() {
		return "\nBrand [id=" + id + ", name=" + name + ", country=" + country +  ", devices=" + devices + "]";
	}
	
	
}
