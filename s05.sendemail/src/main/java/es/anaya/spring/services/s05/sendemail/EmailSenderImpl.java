package es.anaya.spring.services.s05.sendemail;

import java.io.File;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements EmailSender {

  @Autowired
  public JavaMailSender emailSender;

  public void sendMessage(Headers headers) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(headers.getTo());
    message.setSubject(headers.getSubject());
    message.setText(headers.getText());
    emailSender.send(message);

  }

  public void sendWithAttachment(Headers headers, String pathToAttachment) throws Exception {
    MimeMessage mimeMessage = emailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

    helper.setTo(headers.getTo());
    helper.setSubject(headers.getSubject());
    helper.setText(headers.getText());

    FileSystemResource file = new FileSystemResource(new File(pathToAttachment));

    helper.addAttachment("Sample Atachment", file);

    emailSender.send(mimeMessage);
  }
}
