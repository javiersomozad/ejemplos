package es.anaya.spring.web.s04.mustache;

public class CustomerType {
	private Long id;
	private String type;
	
	public CustomerType(Long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CustomerType [id=" + id + ", type=" + type + "]";
	}
	
	
	
}
