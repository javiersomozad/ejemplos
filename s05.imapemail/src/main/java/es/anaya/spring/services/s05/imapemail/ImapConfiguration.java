package es.anaya.spring.services.s05.imapemail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mail.ImapIdleChannelAdapter;
import org.springframework.integration.mail.ImapMailReceiver;
import org.springframework.messaging.MessageChannel;

import java.util.Properties;

@Configuration
class ImapConfiguration {

	private Properties javaMailProperties() {
		Properties javaMailProperties = new Properties();

		javaMailProperties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		javaMailProperties.setProperty("mail.imap.socketFactory.fallback", "false");
		javaMailProperties.setProperty("mail.store.protocol", "imaps");
		javaMailProperties.setProperty("mail.debug", "true");
		javaMailProperties.setProperty("mail.imap.username", "pello.altadill");
		javaMailProperties.setProperty("mail.imap.password", "Hmr!2012");
		return javaMailProperties;
	}

	@Bean
	ImapIdleChannelAdapter mailAdapter() {
		ImapMailReceiver mailReceiver = new ImapMailReceiver("imaps://login:pass@imap-server:993/INBOX");

		mailReceiver.setJavaMailProperties(javaMailProperties());
		mailReceiver.setShouldDeleteMessages(false);
		mailReceiver.setShouldMarkMessagesAsRead(true);

		return new ImapIdleChannelAdapter(mailReceiver);
	}

	@Bean
	public MessageChannel emails() {
		return new DirectChannel();
	}

}