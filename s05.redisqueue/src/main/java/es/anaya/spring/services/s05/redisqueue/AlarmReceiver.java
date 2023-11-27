package es.anaya.spring.services.s05.redisqueue;

public class AlarmReceiver {
	public void receiveMessage(String alarm) {
		System.out.println("Received message: " + alarm);
	}
}