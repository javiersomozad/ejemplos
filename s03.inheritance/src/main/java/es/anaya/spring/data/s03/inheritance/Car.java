package es.anaya.spring.data.s03.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CAR")
public class Car extends MotorVehicle {
  private String license;
  private String fuel;
  
  public Car() {
  }

  public Car(String name, Float range, String license, String fuel) {
    super(name, range);
    this.license = license;
    this.fuel = fuel;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getFuel() {
    return fuel;
  }

  public void setFuel(String fuel) {
    this.fuel = fuel;
  }
  
  @Override
  public String toString() {
    return "Car [license=" + license + ", fuel=" + fuel + "]" + super.toString();
  }

}
