package es.anaya.spring.data.s03.customjpaquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moon {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @Column(name="moonNumber")
  private Integer number;
  
  public Moon () {}
  
  public Moon(Long id, String name, Integer number) {
    this.id = id;
    this.name = name;
    this.number = number;
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

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Moon [id=" + id + ", name=" + name + ", number=" + number + "]";
  }
  
  
}
