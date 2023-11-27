package es.anaya.spring.data.s03.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Newspaper {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "newspaper_subscriptor", 
      joinColumns = @JoinColumn(name = "newspaper_id", 
                    referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "subscriptor_id", 
                       referencedColumnName = "id"))
  private List<Subscriptor> subscriptors = new ArrayList<Subscriptor>();

  public Newspaper () {}
  
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

  public List<Subscriptor> getSubscriptors() {
    return subscriptors;
  }

  public void setSubscriptors(List<Subscriptor> subscriptors) {
    this.subscriptors = subscriptors;
  }

  @Override
  public String toString() {
    return "\nNewspaper [id=" + id + ", name=" + name + ", subscriptors=" + subscriptors + "]";
  }
  
  
  
}
