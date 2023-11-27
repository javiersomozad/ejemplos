package es.anaya.spring.basic.s01.lifecycle.replicant;

public class Replicant {
	private String name;
	private String model;
	
	public Replicant () {}
	
	public Replicant(String name, String model) {
		this.name = name;
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
    public void initReplicant()  {
        System.out.println("Replicant> I'll see things.. " + this);
    }

    public void destroyReplicant() {
        System.out.println("Replicant> Time to die. " + this);

    }

	@Override
	public String toString() {
		return "Replicant [name=" + name + ", model=" + model + "]";
	}
    
}
