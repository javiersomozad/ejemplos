package es.anaya.spring.services.s05.imapemail;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.integration.mail.MailReceiver;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailReceiverImpl implements EmailReceiver {
  
    @Autowired
    public MailReceiver emailSender;
 
    public void sendMessage(   Headers headers) {


    }

    public void sendWithAttachment(Headers headers, String pathToAttachment) throws Exception {

    }
}
