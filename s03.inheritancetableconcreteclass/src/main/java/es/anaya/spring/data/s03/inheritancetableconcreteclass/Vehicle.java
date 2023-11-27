package es.anaya.spring.data.s03.inheritancetableconcreteclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)  // In this strategy is needed!!!
  private Long id;
  private String name;
  
  public Vehicle () {}
  
  public Vehicle (String name2) {}

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

  @Override
  public String toString() {
    return "\nVehicle [id=" + id + ", name=" + name + "]";
  }
  
}
