package es.anaya.spring.web.s04.complexform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SignUpController {

    @GetMapping("/")
    public String greetingForm() {
        return "index";
    }
    
    @GetMapping("/signup")
    public String greetingForm(Model model) {    	
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signup")
    public String greetingSubmit(@ModelAttribute User user, Model model) {
    	model.addAttribute("user",user);
        return "postResult";
    }

}