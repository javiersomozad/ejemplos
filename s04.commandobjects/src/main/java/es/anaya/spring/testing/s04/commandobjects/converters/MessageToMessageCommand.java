package es.anaya.spring.testing.s04.commandobjects.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import es.anaya.spring.testing.s04.commandobjects.commands.MessageCommand;
import es.anaya.spring.testing.s04.commandobjects.domain.Message;


@Component
public class MessageToMessageCommand implements Converter<Message, MessageCommand> {

  @Synchronized
  @Nullable
  @Override
  public MessageCommand convert(Message message) {
    if (message == null) {
      return null;
    }

    final MessageCommand messageCommand = new MessageCommand();

    messageCommand.setId(message.getId());
    messageCommand.setTitle(message.getTitle());
    messageCommand.setContent(message.getContent());

    return messageCommand;
  }
}