package es.anaya.spring.web.s04.basiclogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/public")
    public String publicPage() {
        return "public";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/protected")
    public String protectedPage() {
        return "protected";
    }
}