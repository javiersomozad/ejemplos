package es.anaya.spring.testing.s04.commandobjects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import es.anaya.spring.testing.s04.commandobjects.domain.Message;
import es.anaya.spring.testing.s04.commandobjects.repositories.MessageRepository;
import es.anaya.spring.testing.s04.commandobjects.converters.MessageCommandToMessage;
import es.anaya.spring.testing.s04.commandobjects.converters.MessageToMessageCommand;
import es.anaya.spring.testing.s04.commandobjects.services.MessageService;
import es.anaya.spring.testing.s04.commandobjects.services.MessageServiceImpl;


public class MessageServiceImplTest {
	
	private MessageService messageService;
	
	@Mock 
	private MessageRepository messageRepository;
	
	@Mock 
	private MessageToMessageCommand messageToMessageCommand;
	
	@Mock 
	private MessageCommandToMessage messageCommandToMessage;
	
	@Before
	public void setUp () throws Exception {
		MockitoAnnotations.initMocks(this);
		messageService = new MessageServiceImpl(messageRepository,messageToMessageCommand, messageCommandToMessage);
	}
	
	@Test
	public void getBugs () throws Exception {
		
		List<Message> bookData = new ArrayList<Message>();
		bookData.add(new Message());
		bookData.add(new Message());

		when(messageService.getMessages()).thenReturn(bookData);
		List<Message> bugs = messageService.getMessages();
		
		assertEquals(bugs.size(), 2);
		verify(messageRepository, times(1)).findAll();
	}
}
