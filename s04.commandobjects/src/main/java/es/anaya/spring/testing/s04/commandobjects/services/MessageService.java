package es.anaya.spring.testing.s04.commandobjects.services;

import java.util.List;
import java.util.Optional;

import es.anaya.spring.testing.s04.commandobjects.commands.MessageCommand;
import es.anaya.spring.testing.s04.commandobjects.domain.Message;

public interface MessageService {
	public Optional<Message> getById(Long id);
	public List<Message> getMessages();
	public MessageCommand saveMessage(MessageCommand messageCommand);
}
