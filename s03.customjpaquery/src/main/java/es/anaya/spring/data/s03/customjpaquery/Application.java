package es.anaya.spring.data.s03.customjpaquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

 @Autowired
 PlanetRepository planetRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = false)
 @Override
 public void run(String... args) throws Exception {

  System.out.println("All: " + planetRepository.findAll());

  System.out.println("By diam: " + planetRepository.findByBiggerThanPosition(200d));
  
  System.out.println("Bigger than: " + planetRepository.findByBiggerThan(300d));

  System.out.println("Random: " + planetRepository.findRandom());
  
  System.out.println("Paginated: " + planetRepository.findPaginated(0,2));
  
  planetRepository.updateNameForDwarfs(300d);
  System.out.println("Pluto: " + planetRepository.findByDiameter(234.3d));
  planetRepository.deleteDwarfs();
  System.out.println("Pluto? " + planetRepository.findByDiameter(234.3d));
  
  System.out.println("How many? " + planetRepository.countPlanets(0));

 }
}
