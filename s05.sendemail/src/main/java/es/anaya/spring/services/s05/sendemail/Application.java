package es.anaya.spring.services.s05.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EmailSender emailSenderImpl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Sending email...");
		Headers headers = new Headers("<PUT_A_VALID_EMAIL>","From Spring", "This works");
		emailSenderImpl.sendMessage(headers);
		
		headers = new Headers("<PUT_A_VALID_EMAIL>","From Spring with attachment", "This works");
		emailSenderImpl.sendWithAttachment(headers, "pom.xml");

	}
}
