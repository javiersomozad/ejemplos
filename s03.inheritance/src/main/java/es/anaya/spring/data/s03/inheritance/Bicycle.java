package es.anaya.spring.data.s03.inheritance;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BYC")
public class Bicycle extends Vehicle {
 private Integer gears;
 
 public Bicycle () {}
 
 public Bicycle (String name, Integer gears) {
  super(name);
  this.gears = gears;
 }

 
 public Integer getGears() {
  return gears;
 }

 public void setGears(Integer gears) {
  this.gears = gears;
 }

 @Override
 public String toString() {
  return "Bicycle [gears=" + gears + "]" + super.toString();
 }

  
}
