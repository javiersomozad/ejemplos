package es.anaya.spring.web.s04.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

    @GetMapping("/")
    public String greetingForm() {
        return "index";
    }
    
    @GetMapping("/message")
    public String greetingForm(Model model) {
    	Message message = new Message();
    	message.setContent("Put something here... ");

        model.addAttribute("message", message);
        
        return "messageForm";
    }

    @PostMapping("/message")
    public String greetingSubmit(@ModelAttribute Message greeting) {
        return "postResult";
    }
}