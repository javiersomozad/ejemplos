package es.anaya.spring.services.s05.restclient;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
  private RestClient restClient;
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Rest Client");
    showAll();
    System.out.println("One: " + restClient.readOne("1"));
    
    Channel channel = new Channel("TeleSpring", new ArrayList<Program>());
    restClient.create(channel);
    showAll();
    
    Channel updatedChannel = restClient.readOne("2");
    updatedChannel.setName("Changed Name");  
    System.out.println("Updated: " + updatedChannel);
    restClient.update(updatedChannel);
    
    showAll();
    
    restClient.delete("1");
    showAll();
  }

  private void showAll() {
    System.out.println("All: ");
    for (Channel c : restClient.readAll()) {
      System.out.println("\t" + c);
    }
  }
}