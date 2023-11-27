package es.anaya.spring.web.s04.customvalidator;

public class Citizen {
	@IdConstraint
	private String id;
	
	private String account;
	
	@PostCodeConstraint
	private String postCode;
	
	public Citizen () {}
	
	public Citizen(String id, String account, String postCode) {
		this.id = id;
		this.account = account;
		this.postCode = postCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", account=" + account + ", postCode=" + postCode + "]";
	}
	
	
}
