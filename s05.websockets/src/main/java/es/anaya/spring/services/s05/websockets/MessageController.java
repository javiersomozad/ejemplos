package es.anaya.spring.services.s05.websockets;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/enter")
    @SendTo("/chat/notifications")
    public Message enter(Message message) throws Exception {
      System.out.println("Entering: " + message);
        return message;
    }
    
    @MessageMapping("/chat")
    @SendTo("/chat/messages")
    public Message greeting(Message message) throws Exception {
      System.out.println("Received message: " + message);
        return message;
    }

}