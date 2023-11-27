package es.anaya.spring.services.s05.imapemail;

import java.util.Scanner;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.aspectj.bridge.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.mail.ImapIdleChannelAdapter;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.integration.mail.support.DefaultMailHeaderMapper;
import org.springframework.integration.mail.transformer.MailToStringTransformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.test.mail.TestMailServer;
import org.springframework.messaging.MessageChannel;


//SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Mailman mailman = (Mailman)context.getBean("mailman");
		MessageChannel receiveEmailChannel = (MessageChannel)context.getBean("receiveEmailChannel");

		//receiveEmailChannel.send((Message<String>)MessageBuilder.withPayload("test").build());
		/*while(true){
			
		}*/
		((ConfigurableApplicationContext) context).close();

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * System.out.println("Receiving email..."); Scanner scanner = new
		 * Scanner(System.in); System.out.println("Enter username"); String user =
		 * scanner.next(); System.out.println("Enter pw"); String pw = scanner.next();
		 * scanner.close(); startMail(user, pw); Thread.sleep(10_000);
		 */
		/*
		 * mailAdapter.get mailAdapter.subscribe(new MessageHandler() {
		 * 
		 * @Override public void handleMessage(Message<?> message) throws
		 * MessagingException {
		 * 
		 * 
		 * MailToStringTransformer m2s = new MailToStringTransformer();
		 * m2s.setCharset("utf-8"); System.out.println("Message: " +
		 * m2s.transform(message));
		 * 
		 * System.out.println("Message: " + message.getPayload()); Object payload =
		 * message.getPayload();
		 * 
		 * if (payload instanceof MimeMessage) { try {
		 * 
		 * javax.mail.Message mailMessage = (javax.mail.Message) payload;
		 * System.out.println(mailMessage.getSubject());
		 * System.out.println(getTextFromMessage(mailMessage));
		 * 
		 * Address[] receipts = mailMessage.getAllRecipients();
		 * System.out.println("RECEIPIENTS MAIL ID"); if (receipts != null &&
		 * receipts.length > 0) { for (int i = 0; i < receipts.length; i++) {
		 * System.out.println(((InternetAddress) receipts[i]).getAddress()); } }
		 * 
		 * System.out.println("FROM MAIL ID"); Address[] froms = mailMessage.getFrom();
		 * String email = froms == null ? null : ((InternetAddress)
		 * froms[0]).getAddress(); System.out.println(email);
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * } } }); }
		 * 
		 * private static String getTextFromMessage(javax.mail.Message message) throws
		 * Exception { String result = ""; if (message.isMimeType("text/plain")) {
		 * result = message.getContent().toString(); } else if
		 * (message.isMimeType("multipart/*")) { MimeMultipart mimeMultipart =
		 * (MimeMultipart) message.getContent(); result =
		 * getTextFromMimeMultipart(mimeMultipart); } return result; }
		 * 
		 * private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart)
		 * throws Exception { String result = ""; int count = mimeMultipart.getCount();
		 * for (int i = 0; i < count; i++) { BodyPart bodyPart =
		 * mimeMultipart.getBodyPart(i); if (bodyPart.isMimeType("text/plain")) { result
		 * = result + "\n" + bodyPart.getContent(); break; // without break same text
		 * appears twice in my tests } else if (bodyPart.isMimeType("text/html")) {
		 * String html = (String) bodyPart.getContent(); // result = result + "\n" +
		 * org.jsoup.Jsoup.parse(html).text(); } else if (bodyPart.getContent()
		 * instanceof MimeMultipart) { result = result +
		 * getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()); } } return
		 * result; }
		 */
	}
}
