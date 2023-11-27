package es.anaya.spring.testing.s04.commandobjects.converters;


import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import es.anaya.spring.testing.s04.commandobjects.commands.MessageCommand;
import es.anaya.spring.testing.s04.commandobjects.domain.Message;

@Component
public class MessageCommandToMessage 
		implements Converter<MessageCommand, Message>{

    @Synchronized
    @Nullable
    @Override
	public Message convert(MessageCommand messageCommand) {
    if (messageCommand == null) {
      return null;
    }

    final Message message = new Message();
    message.setId(messageCommand.getId());
    message.setTitle(messageCommand.getTitle());
    message.setContent(messageCommand.getContent());
    return message;
  }
}