package es.anaya.spring.services.s05.imapemail;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;

public class Mailman {
	
	public void receive(MimeMessage message) {
		System.out.println("hello");
		System.out.println(message);
	}

}
