package es.anaya.spring.services.s05.redis;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  @Autowired
private AlarmRepository alarmRepository;
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    
    Alarm alarm1 = new Alarm("Alarm1", "Redis is ready", new Date());
    Alarm alarm2 = new Alarm("Alarm2", "Redis is working", new Date());
    Alarm alarm3 = new Alarm("Alarm3", "Redis is shuting down", new Date());
  
    alarmRepository.save(alarm1);
    alarmRepository.save(alarm2);
    alarmRepository.save(alarm3);
    
    System.out.println(alarmRepository.findAll());
    
    System.out.println(alarmRepository.findById("Alarm2"));
    
    alarm2.setData("Changed Data");
    alarmRepository.update(alarm2);
    System.out.println(alarmRepository.findAll());
    
    alarmRepository.delete(alarm3.getId());
    
    System.out.println(alarmRepository.findAll());
  }

}