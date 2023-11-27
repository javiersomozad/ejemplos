package es.anaya.spring.reactive.s06.helloreactive;

public class ProductCommand {
	private Long id;
	private String name;
	private Float price;
	
	public ProductCommand () {}
	
	public ProductCommand(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
	}
	
	public ProductCommand(Long id, String name, Float price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductCommand [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
}
