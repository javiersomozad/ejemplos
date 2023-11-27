package es.anaya.spring.services.s05.imapemail;

public interface EmailReceiver {

    public void sendMessage(Headers headers);
	void sendWithAttachment(Headers headers, String pathToAttachment) throws Exception;

}
