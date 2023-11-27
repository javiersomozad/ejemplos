package es.anaya.spring.data.s03.onetoonebidir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {
 @Autowired
 BarRepository barRepository;

 @Autowired
 LicenseRepository licenseRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = false)
 @Override
 public void run(String... args) throws Exception {

  System.out.println(barRepository.findAll());

  Bar bar = new Bar();
  bar.setName("Haddock");
  bar.setAddress("c/ Drunkard 6");
  bar.setLicense(new License());

  barRepository.save(bar);
  System.out.println(barRepository.findAll());

  barRepository.delete(bar);
  System.out.println(barRepository.findAll());
 }
}
