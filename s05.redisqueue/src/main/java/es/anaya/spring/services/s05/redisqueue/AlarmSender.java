package es.anaya.spring.services.s05.redisqueue;

import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class AlarmSender implements Runnable {
    private Random random = new Random();
    
  @Autowired
  private StringRedisTemplate redisTemplate;

    public AlarmSender() {  }

    public void sendAlarm() {
      int number = random.nextInt(20);
      Alarm alarm = new Alarm("Alarm"+number, "Alarm nº " + number, new Date());
        System.out.println("Sending alarm: " + alarm);
        redisTemplate.convertAndSend("alarm_channel", alarm.toString());
    }

  @Override
  public void run() {
    try {
      do {
        Thread.sleep(random.nextInt(5000));
        sendAlarm();
      } while(true);
    } catch (InterruptedException eix) {
      System.err.println("Exception sending: " + eix.getMessage());
    }
    
  }
}