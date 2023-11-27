package es.anaya.spring.testing.s04.commandobjects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import es.anaya.spring.testing.s04.commandobjects.domain.Message;
import es.anaya.spring.testing.s04.commandobjects.controllers.MessageController;
import es.anaya.spring.testing.s04.commandobjects.services.MessageService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class MessageControllerTest {

    @Mock
    MessageService messageService;

    @Mock
    Model model;

    MessageController messageController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        messageController = new MessageController(messageService);
    }

    @Test
    public void testIndexPage() throws Exception {

        String viewName = messageController.list(model);

        assertEquals("messages", viewName);
        verify(messageService, times(1)).getMessages();
        verify(model, times(1)).addAttribute(eq("messages"), anyList());
    }
    
    @Test
    public void testModelIndexPage() throws Exception {
    	List<Message> messages = new ArrayList();

    	messages.add(new Message(1L,"a","aa"));
    	messages.add(new Message(2L,"b","bb"));    	
    	messages.add(new Message(3L,"c","cc"));  	
    	
    	when(messageService.getMessages()).thenReturn(messages);
    	ArgumentCaptor<List<Message>> argumentCaptor = ArgumentCaptor.forClass(List.class);
    	
        String viewName = messageController.list(model);

        assertEquals("messages", viewName);
        verify(messageService, times(1)).getMessages();
        
        verify(model, times(1)).addAttribute(eq("messages"), argumentCaptor.capture());
        
        List<Message> listInsideController = argumentCaptor.getValue();
        assertEquals(3, listInsideController.size());
    }

}