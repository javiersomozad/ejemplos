package es.anaya.spring.basic.s01.lifecycle.replicant;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BladeRunner {
	private String name;
	private String license;

	public BladeRunner() {
	}

	public BladeRunner(String name, String license) {
		this.name = name;
		this.license = license;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@PostConstruct
	public void initBladeRunner() {
		System.out.println("BladeRunner> ready to serve. " + this);
	}

	@PreDestroy
	public void destroyBladeRunner() {
		System.out.println("BladeRunner> retired. " + this);

	}

	@Override
	public String toString() {
		return "BladeRunner [name=" + name + ", license=" + license + "]";
	}

}
