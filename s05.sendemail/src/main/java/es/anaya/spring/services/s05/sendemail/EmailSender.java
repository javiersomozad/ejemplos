package es.anaya.spring.services.s05.sendemail;

public interface EmailSender {
    public void sendMessage(Headers headers);
	void sendWithAttachment(Headers headers, String pathToAttachment) throws Exception;
}
