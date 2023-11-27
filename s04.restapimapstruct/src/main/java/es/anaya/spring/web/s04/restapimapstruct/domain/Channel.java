package es.anaya.spring.web.s04.restapimapstruct.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Channel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  
  @OneToMany(cascade=CascadeType.ALL, mappedBy="channel")  
  private List<Program> programs = new ArrayList<Program>();
}
