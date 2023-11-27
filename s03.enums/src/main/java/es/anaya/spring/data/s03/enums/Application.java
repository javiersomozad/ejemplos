package es.anaya.spring.data.s03.enums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {
 @Autowired
 PlayerRepository playerRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = true)
 @Override
 public void run(String... args) throws Exception {

  Player player = new Player("Arkonada",1, Position.GOALKEEPER);
  
  playerRepository.save(player);
  
  System.out.println("Showing all players");
  for (Player p : playerRepository.findAll()) {
   System.out.println(p);
  }

  System.out.println("Showing all strikers");
  for (Player p : playerRepository.findByPosition(Position.FORWARD)) {
   System.out.println(p);
  }
  
 }
}
