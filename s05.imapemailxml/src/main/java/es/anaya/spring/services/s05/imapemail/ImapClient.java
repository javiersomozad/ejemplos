package es.anaya.spring.services.s05.imapemail;

import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import java.util.Arrays;
import javax.mail.internet.MimeMessage;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;

public class ImapClient {

  private DirectChannel receiveEmailChannel;

  public ImapClient() {
  }

  public void subscribeToNewMessages() {
    receiveEmailChannel.subscribe(new MessageHandler() {
      @Override
      public void handleMessage(Message<?> message) throws MessagingException {
        System.err.println("******************* NEW MESSAGE ********************");
        System.err.println("Message: " + message);
        System.err.println("****************************************************");
      }
    });
  }

  public void receive(MimeMessage message) throws Exception {
    System.out.println("****************************************************");
    System.out.println("Id: " + message.getMessageID());
    System.out.println("From: " + Arrays.toString(message.getFrom()));
    System.out.println("To: " + Arrays.toString(message.getAllRecipients()));
    System.out.println("Subject: " + message.getSubject().toString());
    System.out.println("****************************************************");
  }

  public DirectChannel getReceiveEmailChannel() {
    return receiveEmailChannel;
  }

  public void setReceiveEmailChannel(DirectChannel receiveEmailChannel) {
    this.receiveEmailChannel = receiveEmailChannel;
  }

}
