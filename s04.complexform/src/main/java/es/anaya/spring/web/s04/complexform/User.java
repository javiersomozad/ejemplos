package es.anaya.spring.web.s04.complexform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private String username;
	private String password;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private Integer status;
	private String sex;
	private List<Integer> vehicles = new ArrayList<Integer>();
	
	public User () {
		this.birth = new Date();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Integer> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Integer> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", description=" + description + ", birth="
				+ birth + ", status=" + status + ", sex=" + sex + ", vehicles=" + vehicles + "]";
	}	
}