package es.anaya.spring.services.s05.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	public void receiveMessage(Object message) {
		System.out.println("Message was received: " + message);
	}
}